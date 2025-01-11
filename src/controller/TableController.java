package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableController {
	public int getTableNo(String tableId) {
		DatabaseHandler.getInstance().connect();
		int table_no = 0;
		String rescheduleBookTableQuery = "SELECT table_no FROM tables WHERE table_id = '" + tableId + "'";

		try {
			PreparedStatement stmt = DatabaseHandler.getInstance().con.prepareStatement(rescheduleBookTableQuery);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				table_no = rs.getInt("table_no");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseHandler.getInstance().disconnect();
		}

		return table_no;
	}
}
