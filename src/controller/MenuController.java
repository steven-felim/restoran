package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuController {

    public List<Menu> getMenuList() {
        List<Menu> menus = new ArrayList<>();
        String query = "SELECT * FROM fnb";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran", "root", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                menus.add(new Menu(
                        rs.getInt("fnb_id"),
                        rs.getString("name"),
                        rs.getInt("stock"),
                        rs.getInt("price")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }
}
