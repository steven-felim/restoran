package controller;

import java.sql.*;
import java.util.Date;

public class BookingController implements BookingService {

    @Override
    public void bookTable(int tableId, int userId, Date date) {
        String query = "INSERT INTO booktable (table_id, user_id, date, status) VALUES (?, ?, ?, 'BOOKED')";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran", "root", "password");
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, tableId);
            pstmt.setInt(2, userId);
            pstmt.setDate(3, new java.sql.Date(date.getTime()));
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelBooking(int bookId) {
        String query = "UPDATE booktable SET status = 'AVAILABLE' WHERE book_id = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran", "root", "password");
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, bookId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

