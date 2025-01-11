package controller;

import model.classes.Cart;
import model.classes.FoodAndBeverage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartController {
    public List<Cart> getAllMemberCart(int userId) {
        List<Cart> cartList = new ArrayList<>();

        DatabaseHandler.getInstance().connect();
        try (
                Statement stmt = DatabaseHandler.getInstance().con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT c.*, ci.*, f.* FROM cart AS c " +
                        "INNER JOIN cart_items AS ci ON c.cart_id = ci.cart_id " +
                        "INNER JOIN fnb AS f ON ci.fnb_id = f.fnb_id " +
                        "WHERE c.user_id = " + userId + " AND c.checkout_status = 0;")) {

            while (rs.next()) {
                int cartId = rs.getInt("c.cart_id");
                int fnbId = rs.getInt("f.fnb_id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                int quantity = rs.getInt("quantity");
                Cart.Builder builder = new Cart.Builder().setCart_Id(cartId).setFnb(new FoodAndBeverage(fnbId, name, stock, price)).setCheckoutStatus(false).setQuantity(quantity);
                cartList.add(new Cart(builder));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }

        return cartList;
    }

    public int getTotalCart() {
        int userId = AuthenticationHelper.getInstance().getRoleId();
        int totalPrice = 0;
        for (Cart cart : getAllMemberCart(userId)) {
            totalPrice += cart.getFnb().getPrice() * cart.getQuantity();
        } return totalPrice;
    }

    public void addItemToCart(int cartId, int fnbId, int quantity) {
        DatabaseHandler.getInstance().connect();
        String query = "INSERT INTO cart_items (cart_id, fnb_id, quantity) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);
            pstmt.setInt(1, cartId);
            pstmt.setInt(2, fnbId);
            pstmt.setInt(3, quantity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
    }

    public void editCartQuantity(int cartId, int fnbId, int quantity) {
        DatabaseHandler.getInstance().connect();
        String query = "UPDATE cart_items SET quantity = ? WHERE cart_id = " + cartId + " AND fnb_id = " + fnbId + ";";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);
            pstmt.setInt(1, quantity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
    }

    public void deleteCartItems(int cartId, int fnbId) {
        DatabaseHandler.getInstance().connect();
        String query = "DELETE FROM cart_items WHERE cart_id = ? AND fnb_id = ?";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);
            pstmt.setInt(1, cartId);
            pstmt.setInt(2, fnbId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
    }

    public Cart findOrCreateCartForMember(int userId) {
        Cart existingCart = getMemberCart(userId);
        if (existingCart == null) {
            return createCartForMember(userId);
        }
        return existingCart;
    }

    private Cart createCartForMember(int userId) {
        DatabaseHandler.getInstance().connect();
        String query = "INSERT INTO cart (user_id, checkout_status) VALUES (?, FALSE)";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
        return getMemberCart(userId);
    }

    private Cart getMemberCart(int userId) {
        DatabaseHandler.getInstance().connect();
        Cart.Builder cartBuilder;
        Cart cart = null;
        try {
            Statement stmt = DatabaseHandler.getInstance().con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cart WHERE user_id = " + userId + " AND checkout_status = 0 LIMIT 1;");
            if (rs.next()) {
                Integer cartId = rs.getInt("cart_id");
                Boolean checkoutStatus = rs.getBoolean("checkout_status");
                cartBuilder = new Cart.Builder().setCart_Id(cartId).setUser_id(userId).setCheckoutStatus(checkoutStatus);
                cart = new Cart(cartBuilder);
            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
        return cart;
    }
}