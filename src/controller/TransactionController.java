package controller;

import model.classes.Transaction;
import model.enums.TransactionStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionController {
    public List<Transaction> getAllTransaction() {
        List<Transaction> transList = new ArrayList<>();

        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT t.transaction_id, t.cart_id, t.voucher_id, t.date, t.status, " +
                        "c.user_id, c.guest_id, SUM(ci.quantity * f.price) AS total " +
                        "FROM transaction AS t " +
                        "INNER JOIN cart AS c ON t.cart_id = c.cart_id " +
                        "INNER JOIN cart_items AS ci ON c.cart_id = ci.cart_id " +
                        "INNER JOIN fnb AS f ON ci.fnb_id = f.fnb_id " +
                        "GROUP BY t.transaction_id")) {

            while (rs.next()) {
                int id = rs.getInt("transaction_id");
                int user_id = rs.getInt("user_id");
                int guest_id = rs.getInt("guest_id");
                int cart_id = rs.getInt("cart_id");
                Date date = rs.getDate("date");
                TransactionStatus status = null;
                switch (rs.getString("status")) {
                    case "PENDING":
                        status = TransactionStatus.PENDING;
                        break;
                    case "SUCCESS":
                        status = TransactionStatus.SUCCESS;
                        break;
                }
                int voucher_id = rs.getInt("voucher_id");
                int total = rs.getInt("total");

                transList.add(new Transaction(id, user_id, guest_id, cart_id, voucher_id, date, status, total));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transList;
    }

    public List<Transaction> getMemberTransaction(int searchID) {
        List<Transaction> transList = new ArrayList<>();

        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT t.transaction_id, t.cart_id, t.voucher_id, t.date, t.status, " +
                        "c.user_id, SUM(ci.quantity * f.price) AS total " +
                        "FROM transaction AS t " +
                        "INNER JOIN cart AS c ON t.cart_id = c.cart_id " +
                        "INNER JOIN cart_items AS ci ON c.cart_id = ci.cart_id " +
                        "INNER JOIN fnb AS f ON ci.fnb_id = f.fnb_id " +
                        "WHERE c.user_id = " + searchID + " " +
                        "GROUP BY t.transaction_id")) {

            while (rs.next()) {
                int id = rs.getInt("transaction_id");
                int user_id = rs.getInt("user_id");
                int cart_id = rs.getInt("cart_id");
                Date date = rs.getDate("date");
                TransactionStatus status = null;
                switch (rs.getString("status")) {
                    case "PENDING":
                        status = TransactionStatus.PENDING;
                        break;
                    case "SUCCESS":
                        status = TransactionStatus.SUCCESS;
                        break;
                }
                int voucher_id = rs.getInt("voucher_id");
                int total = rs.getInt("total");

                transList.add(new Transaction(id, user_id, -1, cart_id, voucher_id, date, status, total));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transList;
    }

    public List<Transaction> getGuestTransaction(int searchID) {
        List<Transaction> transList = new ArrayList<>();

        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT t.transaction_id, t.cart_id, t.voucher_id, t.date, t.status, " +
                        "c.guest_id, SUM(ci.quantity * f.price) AS total " +
                        "FROM transaction AS t " +
                        "INNER JOIN cart AS c ON t.cart_id = c.cart_id " +
                        "INNER JOIN cart_items AS ci ON c.cart_id = ci.cart_id " +
                        "INNER JOIN fnb AS f ON ci.fnb_id = f.fnb_id " +
                        "WHERE c.guest_id = " + searchID + " " +
                        "GROUP BY t.transaction_id")) {

            while (rs.next()) {
                int id = rs.getInt("transaction_id");
                int guest_id = rs.getInt("guest_id");
                int cart_id = rs.getInt("cart_id");
                Date date = rs.getDate("date");
                TransactionStatus status = null;
                switch (rs.getString("status")) {
                    case "PENDING":
                        status = TransactionStatus.PENDING;
                        break;
                    case "SUCCESS":
                        status = TransactionStatus.SUCCESS;
                        break;
                }
                int voucher_id = rs.getInt("voucher_id");
                int total = rs.getInt("total");

                transList.add(new Transaction(id, -1, guest_id, cart_id, voucher_id, date, status, total));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transList;
    }
}