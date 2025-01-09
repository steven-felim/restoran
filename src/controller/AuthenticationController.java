package controller;

import javax.swing.*;

import view.guest.login.Login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationController {
	public int login(String userProfileField, String passwordField) {
		DatabaseHandler.getInstance().connect();
		String queryGetPassenger = "SELECT user_id, name, email, password, role, jobdesk FROM user";
		try {
			PreparedStatement stmt = DatabaseHandler.getInstance().con.prepareStatement(queryGetPassenger);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String role = rs.getString("role");
				String jobdesk = rs.getString("jobdesk");
				if (name.equalsIgnoreCase(userProfileField) || email.equalsIgnoreCase(userProfileField)) {
					if (new PasswordEncoder().authenticate(passwordField.toCharArray(), password)) {
						AuthenticationHelper.getInstance().setUserId(userId);
						switch (role) {
							case "ADMIN":
								return 1;
							case "MEMBER":
								return 2;
							case "EMPLOYEE":
								switch (jobdesk) {
									case "CASHIER":
										return 3;
									case "CHEF":
										return 4;
									case "DELIVERYMAN":
										return 5;
									case "WAITER":
										return 6;
								}
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseHandler.getInstance().disconnect();
		}

		return 0;
	}

	public void logout() {
	    AuthenticationHelper.getInstance().reset();
		new Login();
	}

	public boolean checkUser() {
		if (AuthenticationHelper.getInstance().getUserId() == 0) {
			new Login();
			JOptionPane.showMessageDialog(
					null,
					"Anda tidak dapat menjalankan program tersebut, " +
							"dikarenakan harus login terlebih dahulu.",
					"Login Terlebih Dahulu",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
