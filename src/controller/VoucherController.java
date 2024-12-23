package controller;

import model.classes.Voucher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VoucherController {
    public List<Voucher> getAllVoucher() {
        List<Voucher> voucherList = new ArrayList<>();
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM voucher")) {
            while (rs.next()) {
                int id = rs.getInt("voucher_id");
                String name = rs.getString("voucher_name");
                Double discount = rs.getDouble("discount");
                int nominal = rs.getInt("nominal");
                int point = rs.getInt("point");
                voucherList.add(new Voucher(id, name, discount, nominal, point));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voucherList;
    }
}
