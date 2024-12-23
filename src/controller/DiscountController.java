package controller;

import model.classes.Discount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DiscountController {
	public Discount getMemberDisc() {
		DatabaseHandler.getInstance().connect();
		String getMemberDiscQuery = "SELECT discount_percent FROM discount WHERE role = 'MEMBER'";
		try {
			PreparedStatement stmt = DatabaseHandler.getInstance().con.prepareStatement(getMemberDiscQuery);
			ResultSet rs = stmt.executeQuery();
			return new Discount(rs.getInt("dicsount_percent"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseHandler.getInstance().disconnect();
		}

		return null;
	}

	public Discount getGuestDisc() {
		DatabaseHandler.getInstance().connect();
		String getGuestDiscQuery = "SELECT discount_percent FROM discount WHERE role = 'GUEST'";
		try {
			PreparedStatement stmt = DatabaseHandler.getInstance().con.prepareStatement(getGuestDiscQuery);
			ResultSet rs = stmt.executeQuery();
			return new Discount(rs.getInt("discount_percent"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseHandler.getInstance().disconnect();
		}

		return null;
	}

	public boolean updateMemberDiscount(double member) {
		DatabaseHandler.getInstance().connect();
		String query = "UPDATE discount SET discount_percent = " + member + " WHERE role = 'MEMBER';";
		try {
			PreparedStatement stmt = DatabaseHandler.getInstance().con.prepareStatement(query);
			int check = stmt.executeUpdate();

			if (check == 0) {
				return (false);
			}
			return (true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseHandler.getInstance().disconnect();
		}
		return (false);
	}

	public boolean updateGuestDiscount(double guest) {
		DatabaseHandler.getInstance().connect();
		String query = "UPDATE discount SET discount_percent = " + guest + " WHERE role = 'GUEST';";
		try {
			Statement stmt = DatabaseHandler.getInstance().con.createStatement();
			int check = stmt.executeUpdate(query);

			if (check == 0) {
				return (false);
			}
			return (true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseHandler.getInstance().disconnect();
		}
		return (false);
	}
}
