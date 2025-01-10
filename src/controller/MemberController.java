package controller;

import model.classes.Member;
import model.classes.Wallet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberController {
    public Member getDataFromDB (int searchID) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        Member member = null;
        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE user_id = " + searchID + ";")) {
            while (rs.next()) {
                Integer id = rs.getInt("user_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = null;
                String cellphone = rs.getString("cellphone");
                String pin  = rs.getString("pin");
                double balance = rs.getDouble("wallet_balance");
                int point = rs.getInt("point");
                member = new Member(id, name, email, password, cellphone, new Wallet(balance, pin), point);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }
}
