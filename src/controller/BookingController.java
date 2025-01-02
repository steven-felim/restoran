package controller;

import model.classes.BookTable;
import model.classes.FoodAndBeverage;
import model.enums.BookStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingController {
	
	public void bookTable(int tableId, int userId, Date date) {
		DatabaseHandler.getInstance().connect();
		String query = "INSERT INTO booktable (table_id, user_id, date, status) VALUES (?, ?, ?, 'BOOKED')";

		try {
			PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

			pstmt.setInt(1, tableId);
			pstmt.setInt(2, userId);
			pstmt.setDate(3, new java.sql.Date(date.getTime()));
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseHandler.getInstance().disconnect();
		}
	}

	public void cancelBooking(int bookId) {
		String query = "UPDATE booktable SET status = 'AVAILABLE' WHERE book_id = ?";

		try {
			PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

			pstmt.setInt(1, bookId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseHandler.getInstance().disconnect();
		}
	}

	public List<BookTable> getAllRescheduledBookTable() {
		DatabaseHandler.getInstance().connect();
		List<BookTable> bookList = new ArrayList<>();
		String rescheduleBookTableQuery = "SELECT book_id, table_id, user_id, guest_id, date, status FROM booktable WHERE status = 'PENDING' OR date IN (SELECT date FROM booktable WHERE status = 'PENDING')";

		try {
			PreparedStatement stmt = DatabaseHandler.getInstance().con.prepareStatement(rescheduleBookTableQuery);
			ResultSet rs = stmt.executeQuery();
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
		} finally {
			DatabaseHandler.getInstance().disconnect();
		}

		return bookList;
	}

	public List<BookTable> getAllBookTable() {
		DatabaseHandler.getInstance().connect();
		List<BookTable> bookList = new ArrayList<>();
		String getBookTableQuery = "SELECT book_id, table_id, user_id, guest_id, date, status FROM booktable";

		try {
			PreparedStatement stmt = DatabaseHandler.getInstance().con.prepareStatement(getBookTableQuery);
			ResultSet rs = stmt.executeQuery();
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
		} finally {
			DatabaseHandler.getInstance().disconnect();
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
