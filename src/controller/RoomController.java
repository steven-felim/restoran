package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomController {

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM room";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran", "root", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                RoomType type = RoomType.valueOf(rs.getString("type"));
                rooms.add(new Room(rs.getInt("room_id"), type));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
