package controller;

import model.classes.DatabaseHandler;
import model.classes.FoodAndBeverage;

import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FnBTableController {
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
}