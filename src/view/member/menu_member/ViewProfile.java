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
        JLabel walletLabel = new JLabel("Rp" + walletBalance);
        profilePanel.add(walletLabel);

        add(profilePanel, BorderLayout.CENTER);

        // Tombol Action
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton changePasswordButton = new JButton("Change Password");
        JButton editProfileButton = new JButton("Edit Profile");
        JButton backButton = new JButton("Back");

        changePasswordButton.addActionListener(e -> {
            this.dispose();
            new ChangePassword();
        });

        editProfileButton.addActionListener(e -> {
            this.dispose();
            new EditProfile(); 
        });

        backButton.addActionListener(e -> {
            this.dispose();
            new MemberMenu();
        });

        buttonPanel.add(changePasswordButton);
        buttonPanel.add(editProfileButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewProfile();
    }
}
