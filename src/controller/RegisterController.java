package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterController {
    public String register(String name, String email, String password, String cellphone, String pin) {
        DatabaseHandler.getInstance().connect();
        String query = "SELECT * FROM user WHERE name = ? OR email = ? OR cellphone = ?";
        try {
            PreparedStatement stmt = DatabaseHandler.getInstance().con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, cellphone);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                if (name.equals(rs.getString("name"))) {
                    return "Username \"" + name + "\" sudah ada sebelumnya!";
                }
                if (email.equals(rs.getString("email"))) {
                    return "Email \"" + email + "\" sudah terpakai sebelumnya!";
                }
                if (email.equals(rs.getString("cellphone"))) {
                    return "Cellphone \"" + cellphone + "\" sudah terpakai sebelumnya!";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }

        if (password.length() < 4) {
            return "Buatlah password minimal 4 karakter!";
        }

        password = new PasswordEncoder().hash(password);
        DatabaseHandler.getInstance().connect();
        String queryInsert = "INSERT INTO user(name, email, password, cellphone, role, pin) VALUES (?, ?, ?, ?, 'MEMBER', ?)";
        try {
            PreparedStatement stmt = DatabaseHandler.getInstance().con.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, cellphone);
            stmt.setString(5, pin);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return "Masukkan semua field!";
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }
        return "";
    }
}