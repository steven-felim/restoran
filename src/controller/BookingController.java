package controller;

import model.classes.BookTable;
import model.classes.DatabaseHandler;
import model.classes.FoodAndBeverage;
import model.enums.BookStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingController  {

    //@Override
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

    //@Override
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

    public List<BookTable> getAllRescheduledBookTable() {
        List<BookTable> bookList = new ArrayList<>();

        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT book_id, table_id, user_id, guest_id, date, status " +
                        "FROM booktable WHERE status = 'PENDING' OR date IN (SELECT date FROM booktable WHERE status = 'PENDING')")) {

            while (rs.next()) {
                int book_id = rs.getInt("book_id");
                String table_id = rs.getString("table_id");
                int user_id = rs.getInt("user_id");
                int guest_id = rs.getInt("guest_id");
                Date date = rs.getDate("date");
                BookStatus status = BookStatus.valueOf(rs.getString("status"));

                bookList.add(new BookTable(book_id, table_id, user_id, guest_id, date, status));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    public List<BookTable> getAllBookTable() {
        List<BookTable> bookList = new ArrayList<>();

        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT book_id, table_id, user_id, guest_id, date, status FROM booktable")) {

            while (rs.next()) {
                int book_id = rs.getInt("book_id");
                String table_id = rs.getString("table_id");
                int user_id = rs.getInt("user_id");
                int guest_id = rs.getInt("guest_id");
                Date date = rs.getDate("date");
                BookStatus status = null;
                switch (rs.getString("status")) {
                    case "PENDING":
                        status = BookStatus.PENDING;
                        break;
                    case "BOOKED":
                        status = BookStatus.BOOKED;
                        break;
                }

                bookList.add(new BookTable(book_id, table_id, user_id, guest_id, date, status));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    public List<BookTable> getGuestBookingHistory() {
        List<BookTable> bookList = new ArrayList<>();
        // logic select from db
        return bookList;
    }

    public List<BookTable> getMemberBookTable() {
        List<BookTable> bookList = new ArrayList<>();
        // logic select from db
        return bookList;
    }
}
