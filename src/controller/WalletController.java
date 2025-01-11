package controller;

import model.classes.Wallet;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WalletController {
	public Wallet getWalletMember() {
		return new MemberController().getDataFromDB(
				AuthenticationHelper.getInstance().getRoleId()
		).getWallet();
	}

	public boolean addBalanceMember(String amount, String pin) {
		if (amount.isEmpty() || pin.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Mohon isi semua fieldnya");
			return false;
		} else if (Integer.parseInt(amount) < 0) {
			JOptionPane.showMessageDialog(null, "Amount harus diatas 0");
			return false;
		} else if (pin.length() != 6) {
			JOptionPane.showMessageDialog(null, "Pin wallet harus 6 angka");
			return false;
		} else if (!pin.equals(getWalletMember().getPin())) {
			JOptionPane.showMessageDialog(null, "Pin wallet salah");
			return false;
		}

		DatabaseHandler.getInstance().connect();
		String query = "UPDATE user SET wallet_balance = ? WHERE user_id = ?";
		try {
			PreparedStatement pstmt = DatabaseHandler.getInstance().con.prepareStatement(query);

			pstmt.setDouble(1, getWalletMember().getBalance() + Double.parseDouble(amount));
			pstmt.setInt(2, AuthenticationHelper.getInstance().getRoleId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseHandler.getInstance().disconnect();
		}

		JOptionPane.showMessageDialog(null, "Berhasil menambahkan balance");
		return true;
	}
}
