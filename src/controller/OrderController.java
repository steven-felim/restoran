package controller;

import model.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderController {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/restoran";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public static List<Order> getOrdersByUser(int userId) {
        List<Order> orders = new ArrayList<>();
        
        String query = "SELECT * FROM transaction WHERE user_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, userId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("transaction_id"));
                    order.setMenuId(rs.getInt("cart_id"));
                    order.setQuantity(rs.getInt("quantity"));
                    order.setStatus(rs.getString("status"));
                    
                    orders.add(order);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
}
