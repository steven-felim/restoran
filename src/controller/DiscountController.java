package controller;

import model.classes.DatabaseHandler;
import model.classes.Discount;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DiscountController {
    public Discount getMemberDisc () {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        Discount discount = null;
        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT discount_percent FROM discount WHERE role = 'MEMBER';")) {
            while (rs.next()) {
                double disc = rs.getInt("discount_percent");
                discount = new Discount(disc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discount;
    }

    public Discount getGuestDisc () {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        Discount discount = null;
        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT discount_percent FROM discount WHERE role = 'GUEST';")) {
            while (rs.next()) {
                double disc = rs.getInt("discount_percent");
                discount = new Discount(disc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discount;
    }

    public boolean updateMemberDiscount(double member) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "UPDATE discount SET discount_percent = " + member + " WHERE role = 'MEMBER';";
        try {
            Statement stmt = conn.con.createStatement();
            int check = stmt.executeUpdate(query);
            conn.disconnect();

            if (check==0){
                return (false);
            }
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean updateGuestDiscount(double guest) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "UPDATE discount SET discount_percent = " + guest + " WHERE role = 'GUEST';";
        try {
            Statement stmt = conn.con.createStatement();
            int check = stmt.executeUpdate(query);
            conn.disconnect();

            if(check==0){
                return (false);
            }
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
