package controller;

import model.DatabaseConnection;
import model.classes.Table;
import model.classes.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableController {

    public static List<Table> getAvailableTables() {
        List<Table> tables = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT t.id AS table_id, t.table_no, t.room_id, r.room_name FROM tables t JOIN rooms r ON t.room_id = r.id WHERE t.available = true";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Room room = new Room(rs.getInt("room_id"), rs.getString("room_name"));
                Table table = new Table(rs.getInt("table_id"), rs.getInt("table_no"), room);
                tables.add(table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tables;
    }

    public static boolean bookTable(int tableId, int userId, String date, String time) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Corrected SQL query syntax for booking a table
            String query = "UPDATE tables SET available = false, user_id = ?, booking_date = ?, booking_time = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userId);
            pstmt.setString(2, date);
            pstmt.setString(3, time);
            pstmt.setInt(4, tableId);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean cancelBooking(int tableId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE tables SET available = true, user_id = NULL, booking_date = NULL, booking_time = NULL WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, tableId);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
