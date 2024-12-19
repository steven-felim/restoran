package controller;

import model.classes.DatabaseHandler;
import model.classes.FoodAndBeverage;

import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FnBController {
    public List<FoodAndBeverage> getAllFnb() {
        List<FoodAndBeverage> fnbList = new ArrayList<>();

        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try (
             Statement stmt = conn.con.createStatement();
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
        }

        return fnbList;
    }

    public FoodAndBeverage getDataFromDB (int searchID) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();

        FoodAndBeverage fnb = new FoodAndBeverage();

        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM fnb WHERE fnb_id = " + searchID + ";")) {

            while (rs.next()) {
                fnb.setId(rs.getInt("fnb_id"));
                fnb.setName(rs.getString("name"));
                fnb.setStock(rs.getInt("stock"));
                fnb.setPrice(rs.getInt("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fnb;
    }
}