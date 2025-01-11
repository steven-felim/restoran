package controller;

import model.classes.BookTable;
import model.enums.BookStatus;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingController {
	
	public void bookTable(String tableId, Date date, String time) {
		DatabaseHandler.getInstance().connect();
		Time times = Time.valueOf(LocalTime.parse(time));
		int roleId = AuthenticationHelper.getInstance().getRoleId();
		String role = AuthenticationHelper.getInstance().getRole();
		String query = "INSERT INTO booktable (table_id, " + role + "_id, date, time) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

			pstmt.setString(1, tableId);
			pstmt.setInt(2, roleId);
			pstmt.setDate(3, new java.sql.Date(date.getTime()));
			pstmt.setTime(4, new java.sql.Time(times.getTime()));
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
		String rescheduleBookTableQuery = "SELECT book_id, table_id, user_id, guest_id, date, time, status FROM booktable WHERE status = 'PENDING' OR date IN (SELECT date FROM booktable WHERE status = 'PENDING')";

		try {
			PreparedStatement stmt = DatabaseHandler.getInstance().con.prepareStatement(rescheduleBookTableQuery);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int book_id = rs.getInt("book_id");
				String table_id = rs.getString("table_id");
				int user_id = rs.getInt("user_id");
				int guest_id = rs.getInt("guest_id");
				Date date = rs.getDate("date");
				Time time = rs.getTime("time");
				BookStatus status = BookStatus.valueOf(rs.getString("status"));

				bookList.add(new BookTable(book_id, table_id, user_id, guest_id, date, time, status));
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
		String getBookTableQuery = "SELECT book_id, table_id, user_id, guest_id, date, time, status FROM booktable";

		try {
			PreparedStatement stmt = DatabaseHandler.getInstance().con.prepareStatement(getBookTableQuery);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int book_id = rs.getInt("book_id");
				String table_id = rs.getString("table_id");
				int user_id = rs.getInt("user_id");
				int guest_id = rs.getInt("guest_id");
				Date date = rs.getDate("date");
				Time time = rs.getTime("time");
				BookStatus status = null;
				switch (rs.getString("status")) {
					case "PENDING":
						status = BookStatus.PENDING;
						break;
					case "BOOKED":
						status = BookStatus.BOOKED;
						break;
				}

				bookList.add(new BookTable(book_id, table_id, user_id, guest_id, date, time, status));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseHandler.getInstance().disconnect();
		}

		return bookList;
	}

	public List<BookTable> getGuestBookingHistory() {
		DatabaseHandler.getInstance().connect();
		int guestId = AuthenticationHelper.getInstance().getRoleId();
		List<BookTable> bookList = new ArrayList<>();
		String getBookTableQuery = "SELECT book_id, table_id, guest_id, date, time, status FROM booktable WHERE guest_id = " + guestId;

		try {
			PreparedStatement stmt = DatabaseHandler.getInstance().con.prepareStatement(getBookTableQuery);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int book_id = rs.getInt("book_id");
				String table_id = rs.getString("table_id");
				int guest_id = rs.getInt("guest_id");
				Date date = rs.getDate("date");
				Time time = rs.getTime("time");
				BookStatus status = null;
				switch (rs.getString("status")) {
					case "PENDING":
						status = BookStatus.PENDING;
						break;
					case "BOOKED":
						status = BookStatus.BOOKED;
						break;
				}

				bookList.add(new BookTable(book_id, table_id, -1, guest_id, date, time, status));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseHandler.getInstance().disconnect();
		}

		return bookList;
	}

	public List<BookTable> getMemberBookTable() {
		DatabaseHandler.getInstance().connect();
		int memberId = AuthenticationHelper.getInstance().getRoleId();
		List<BookTable> bookList = new ArrayList<>();
		String getBookTableQuery = "SELECT book_id, table_id, user_id, date, time, status FROM booktable WHERE user_id = " + memberId;

		try {
			PreparedStatement stmt = DatabaseHandler.getInstance().con.prepareStatement(getBookTableQuery);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int book_id = rs.getInt("book_id");
				String table_id = rs.getString("table_id");
				int user_id = rs.getInt("user_id");
				Date date = rs.getDate("date");
				Time time = rs.getTime("time");
				BookStatus status = null;
				switch (rs.getString("status")) {
					case "PENDING":
						status = BookStatus.PENDING;
						break;
					case "BOOKED":
						status = BookStatus.BOOKED;
						break;
				}

				bookList.add(new BookTable(book_id, table_id, user_id, -1, date, time, status));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseHandler.getInstance().disconnect();
		}

		return bookList;
	}
}
