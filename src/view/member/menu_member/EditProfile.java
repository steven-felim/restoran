package view.member.menu_member;

import model.classes.DatabaseHandler;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class EditProfile extends JFrame {

    public EditProfile() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() { 
        setTitle("Edit Profile");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        JLabel title = new JLabel("Edit Profile", SwingConstants.CENTER);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 2, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JTextField usernameField = new JTextField(10);
        JTextField emailField = new JTextField(20);
        JTextField phoneField = new JTextField(20);

        formPanel.add(new JLabel("Username:"));
        formPanel.add(usernameField);

        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);

        formPanel.add(new JLabel("Phone:"));
        formPanel.add(phoneField);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        saveButton.addActionListener(e -> {
            // DatabaseHandler conn = new DatabaseHandler();
            // conn.connect();
            // String query = "UPDATE user SET username = ?, email = ?, phone = ? WHERE id = ?";
            // try (PreparedStatement stmt = conn.con.prepareStatement(query)) {
            //     stmt.setString(1, usernameField.getText());
            //     stmt.setString(2, emailField.getText());
            //     stmt.setString(3, phoneField.getText());
            //     // stmt.setInt(4, Login.userId);
            //     stmt.executeUpdate();
            //     JOptionPane.showMessageDialog(this, "Profile updated successfully!");
            // } catch (SQLException ex) {
            //     ex.printStackTrace();
            // } finally {
            //     conn.disconnect();
            // }
            // this.dispose();
            // new ViewProfile();
        });

        cancelButton.addActionListener(e -> {
            this.dispose();
            new ViewProfile();
        });

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        new EditProfile();
    }
}