package controller;

import model.classes.FoodAndBeverage;
import model.classes.Voucher;

import java.sql.PreparedStatement;
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
                String name = rs.getString("name");
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

    public String addVoucher(String nameVoucher, String discountVoucher, String nominalVoucher, String pointVoucher) {
        int point;
        if (pointVoucher.isEmpty()) {
            point = 0;
        } else if (Integer.parseInt(pointVoucher) < 0) {
            return "Point tidak boleh di bawah 0";
        } else {
            point = Integer.parseInt(pointVoucher);
        }

        int nominal = 0;
        double discount = 0;
        if (nominalVoucher.isEmpty() && discountVoucher.isEmpty()) {
            return "Harus mengisi salah satu dari field \"Voucher Discount\" atau \"Voucher Nominal\"";
        } else if (!nominalVoucher.isEmpty() && Integer.parseInt(nominalVoucher) < 5000) {
            return "Nominal Voucher tidak boleh dibawah 5000";
        } else if (!discountVoucher.isEmpty() && Double.parseDouble(discountVoucher) < 0.1) {
            return "Nominal Voucher tidak boleh dibawah 5000";
        } else if (nominalVoucher.isEmpty()) {
            discount = Double.parseDouble(discountVoucher);
        } else if (discountVoucher.isEmpty()) {
            nominal = Integer.parseInt(nominalVoucher);
        } else {
            nominal = Integer.parseInt(nominalVoucher);
            discount = Double.parseDouble(discountVoucher);
        }

        if (nameVoucher.isEmpty()) {
            return "Harus mengisi field \"Voucher Name\"";
        }
        for (FoodAndBeverage fnb : new FnBController().getAllFnb()) {
            if (nameVoucher.equalsIgnoreCase(fnb.getName())) {
                return "Nama Voucher tersebut telah tersedia";
            }
        }

        DatabaseHandler.getInstance().connect();
        String query = "INSERT INTO voucher (name, discount, nominal, point) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

            pstmt.setString(1, nameVoucher);
            pstmt.setDouble(2, discount);
            pstmt.setInt(3, nominal);
            pstmt.setInt(4, point);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHandler.getInstance().disconnect();
        }

        return "";
    }
}
