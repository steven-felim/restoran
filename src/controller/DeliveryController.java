package controller;

import model.classes.DatabaseHandler;
import model.classes.Delivery;
import model.enums.DeliveryStatus;
import model.enums.TransactionStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliveryController {
    public List<Delivery> getAllDelivery() {
        List<Delivery> deliveryList = new ArrayList<>();

        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try (
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT delivery_id, delivery_status, address, transaction_id, deliveryman_id FROM delivery")) {

            while (rs.next()) {
                int id = rs.getInt("delivery_id");
                DeliveryStatus status = null;
                switch (rs.getString("delivery_status")) {
                    case "PENDING":
                        status = DeliveryStatus.PENDING;
                        break;
                    case "CONFIRMED":
                        status = DeliveryStatus.CONFIRMED;
                        break;
                    case "DELIVERED":
                        status = DeliveryStatus.DELIVERED;
                        break;
                }
                String address = rs.getString("address");
                int trans_id = rs.getInt("transaction_id");
                int delman_id = rs.getInt("deliveryman_id");

                deliveryList.add(new Delivery(id, status, address, trans_id, delman_id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deliveryList;
    }
}
