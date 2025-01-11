package controller;

import model.classes.FoodAndBeverage;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FnBController {
    public List<FoodAndBeverage> getAllFnb() {
        List<FoodAndBeverage> fnbList = new ArrayList<>();

        DatabaseHandler.getInstance().connect();
        try (
             Statement stmt = DatabaseHandler.getInstance().con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM fnb")) {

            while (rs.next()) {
                int id = rs.getInt("fnb_id");
                String name = rs.getString("name");
                int stock = rs.getInt("stock");
                int price = rs.getInt("price");

                fnbList.add(new FoodAndBeverage(id, name, stock, price));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }

        return fnbList;
    }

    public List<FoodAndBeverage> getAllFnbMember() {
        List<FoodAndBeverage> fnbList = new ArrayList<>();
        int userId = AuthenticationHelper.getInstance().getRoleId();

        DatabaseHandler.getInstance().connect();
        try (
             Statement stmt = DatabaseHandler.getInstance().con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT fnb_id FROM favorite_menu WHERE user_id = " + userId)) {

            while (rs.next()) {
                int id = rs.getInt("fnb_id");
                String name = rs.getString("name");
                int stock = rs.getInt("stock");
                int price = rs.getInt("price");

                fnbList.add(new FoodAndBeverage(id, name, stock, price));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }

        return fnbList;
    }

    public String addFnBMenu(String nameMenu, String stockMenu, String priceMenu) {
        int stock;
        if (stockMenu.isEmpty()) {
            stock = 0;
        } else if (Integer.parseInt(stockMenu) < 0) {
            return "Stock tidak boleh di bawah 0";
        } else {
            stock = Integer.parseInt(stockMenu);
        }

        int price;
        if (priceMenu.isEmpty()) {
            return "Harus mengisi field \"Menu Price\"";
        } else if (Integer.parseInt(priceMenu) < 5000) {
            return "Harga tidak boleh dibawah 5000";
        } else {
            price = Integer.parseInt(priceMenu);
        }

        if (nameMenu.isEmpty()) {
            return "Harus mengisi field \"Menu Name\"";
        }
        for (FoodAndBeverage fnb : new FnBController().getAllFnb()) {
            if (nameMenu.equalsIgnoreCase(fnb.getName())) {
                return "Menu tersebut telah tersedia";
            }
        }

        DatabaseHandler.getInstance().connect();
        String query = "INSERT INTO fnb (name, stock, price) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

            pstmt.setString(1, nameMenu);
            pstmt.setInt(2, stock);
            pstmt.setInt(3, price);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }

        return "";
    }

    public String editFnBMenu(int idMenu, String nameMenu, String stockMenu, String priceMenu) {
        int stock;
        if (stockMenu.isEmpty()) {
            stock = 0;
        } else if (Integer.parseInt(stockMenu) < 0) {
            return "Stock tidak boleh di bawah 0";
        } else {
            stock = Integer.parseInt(stockMenu);
        }

        int price;
        if (priceMenu.isEmpty()) {
            return "Harus mengisi field \"Menu Price\"";
        } else if (Integer.parseInt(priceMenu) < 5000) {
            return "Harga tidak boleh dibawah 5000";
        } else {
            price = Integer.parseInt(priceMenu);
        }

        if (nameMenu.isEmpty()) {
            return "Harus mengisi field \"Menu Name\"";
        }
        for (FoodAndBeverage fnb : new FnBController().getAllFnb()) {
            if (nameMenu.equalsIgnoreCase(fnb.getName())) {
                return "Menu tersebut telah tersedia";
            }
        }

        DatabaseHandler.getInstance().connect();
        String query = "UPDATE fnb SET name = ?, stock = ?, price = ? WHERE fnb_id = ?";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

            pstmt.setString(1, nameMenu);
            pstmt.setInt(2, stock);
            pstmt.setInt(3, price);
            pstmt.setInt(4, idMenu);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }

        return "";
    }

    public void deleteFnBMenu(int idFnB) {
        DatabaseHandler.getInstance().connect();

        String query = "DELETE FROM fnb WHERE fnb_id = ?";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

            pstmt.setInt(1, idFnB);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
    }

    public void addFavMenu(int idFnB) {
        DatabaseHandler.getInstance().connect();
        int userId = AuthenticationHelper.getInstance().getRoleId();

        String query = "INSERT INTO favorite_menu VALUES (?, ?)";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

            pstmt.setInt(1, userId);
            pstmt.setInt(2, idFnB);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
    }

    public void delFavMenu(int idFnB) {
        DatabaseHandler.getInstance().connect();
        int userId = AuthenticationHelper.getInstance().getRoleId();

        String query = "DELETE FROM favorite_menu WHERE fnb_id = ? AND user_id = ?";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

            pstmt.setInt(1, idFnB);
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
    }

    public FoodAndBeverage getDataFromDB (int searchID) {
        DatabaseHandler.getInstance().connect();

        FoodAndBeverage fnb = new FoodAndBeverage();

        try (
            Statement stmt = DatabaseHandler.getInstance().con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM fnb WHERE fnb_id = " + searchID + ";")) {

            while (rs.next()) {
                fnb.setId(rs.getInt("fnb_id"));
                fnb.setName(rs.getString("name"));
                fnb.setStock(rs.getInt("stock"));
                fnb.setPrice(rs.getInt("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
        return fnb;
    }
}