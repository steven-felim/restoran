package view.member.menu_member;

import model.classes.DatabaseHandler;
import view.guest.Login;
import view.member.MemberMenu;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ViewProfile extends JFrame {


    public ViewProfile() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("Profile");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Your Profile", SwingConstants.CENTER);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Panel untuk menampilkan informasi profil
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayout(5, 2, 10, 10));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String username = "";
        String email = "";
        String phone = "";
        String walletBalance = "";

        // Ambil data dari database
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "SELECT username, email, phone, wallet_balance FROM user WHERE id = ?";
        try (PreparedStatement stmt = conn.con.prepareStatement(query)) {
            // stmt.setInt(1, Login.class);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                username = rs.getString("username");
                email = rs.getString("email");
                phone = rs.getString("phone");
                walletBalance = String.valueOf(rs.getDouble("wallet_balance"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conn.disconnect();
        }

        // Tambahkan data ke panel
        profilePanel.add(new JLabel("Username:"));
        JLabel usernameLabel = new JLabel(username);
        profilePanel.add(usernameLabel);

        profilePanel.add(new JLabel("Email:"));
        JLabel emailLabel = new JLabel(email);
        profilePanel.add(emailLabel);

        profilePanel.add(new JLabel("Phone:"));
        JLabel phoneLabel = new JLabel(phone);
        profilePanel.add(phoneLabel);

        profilePanel.add(new JLabel("Wallet Balance:"));
        JLabel walletLabel = new JLabel("$" + walletBalance);
        profilePanel.add(walletLabel);

        add(profilePanel, BorderLayout.CENTER);

        // Tombol Action
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton changePasswordButton = new JButton("Change Password");
        JButton editProfileButton = new JButton("Edit Profile");
        JButton logoutButton = new JButton("Logout");

        changePasswordButton.addActionListener(e -> {
            this.dispose();
            new ChangePassword();
        });

        editProfileButton.addActionListener(e -> {
            this.dispose();
            // new EditProfile(username, email, phone); 
        });

        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "You have been logged out.");
            this.dispose();
            new MemberMenu();
        });

        buttonPanel.add(changePasswordButton);
        buttonPanel.add(editProfileButton);
        buttonPanel.add(logoutButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewProfile();
    }
}
