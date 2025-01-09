package controller;

import model.classes.NonGuest;
import model.classes.Wallet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserController {
    public NonGuest getDataFromDB (int searchID) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        NonGuest user = null;
        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE user_id = " + searchID + ";")) {
            while (rs.next()) {
                Integer id = rs.getInt("user_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String cellphone = rs.getString("cellphone");
                user = new NonGuest(id, name, email, password, cellphone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void editUserDetails(int idUser, String name, String email, String cellphone) {
        DatabaseHandler.getInstance().connect();

        String query = "UPDATE user SET name = ?, email = ?, cellphone = ? WHERE user_id = ?";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, cellphone);
            pstmt.setInt(4, idUser);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
    }

    public void editPassword(int idUser, String password) {
        DatabaseHandler.getInstance().connect();
        password = new PasswordEncoder().hash(password);

        String query = "UPDATE user SET password = ? WHERE user_id = ?";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

            pstmt.setString(1, password);
            pstmt.setInt(2, idUser);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
    }
}