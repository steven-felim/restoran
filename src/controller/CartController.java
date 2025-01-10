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
                        "WHERE c.user_id = " + userId + " AND checkout_status = 0;")) {

            while (rs.next()) {
                int cartId = rs.getInt("cart_id");
                int fnbId = rs.getInt("fnb_id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                Cart.Builder builder = new Cart.Builder().setCart_Id(cartId).setFnb(new FoodAndBeverage(fnbId, name, stock, price)).setCheckoutStatus(false);
                cartList.add(new Cart(builder));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }

        return cartList;
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