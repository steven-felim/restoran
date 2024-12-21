package view.member.menu_member;

import model.classes.DatabaseHandler;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangePassword extends JFrame {

    public ChangePassword() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("Change Password");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        JLabel title = new JLabel("Change Password", SwingConstants.CENTER);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPasswordField oldPasswordField = new JPasswordField();
        JPasswordField newPasswordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField();

        formPanel.add(new JLabel("Old Password:"));
        formPanel.add(oldPasswordField);

        formPanel.add(new JLabel("New Password:"));
        formPanel.add(newPasswordField);

        formPanel.add(new JLabel("Confirm Password:"));
        formPanel.add(confirmPasswordField);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        saveButton.addActionListener(e -> {
            // String oldPassword = new String(oldPasswordField.getPassword());
            // String newPassword = new String(newPasswordField.getPassword());
            // String confirmPassword = new String(confirmPasswordField.getPassword());

            // if (newPassword.isEmpty() || confirmPassword.isEmpty() || oldPassword.isEmpty()) {
            //     JOptionPane.showMessageDialog(this, "All fields must be filled!");
            //     return;
            // }

            // if (!newPassword.equals(confirmPassword)) {
            //     JOptionPane.showMessageDialog(this, "New passwords do not match!");
            //     return;
            // }

            // DatabaseHandler conn = new DatabaseHandler();
            // conn.connect();
            // String queryCheck = "SELECT password FROM user WHERE id = ?";
            // String queryUpdate = "UPDATE user SET password = ? WHERE id = ?";

            // try (PreparedStatement stmtCheck = conn.con.prepareStatement(queryCheck);
            //      PreparedStatement stmtUpdate = conn.con.prepareStatement(queryUpdate)) {
            //     // stmtCheck.setInt(1, Login.userId);
            //     ResultSet rs = stmtCheck.executeQuery();

            //     if (rs.next()) {
            //         String currentPassword = rs.getString("password");

            //         if (!currentPassword.equals(oldPassword)) {
            //             JOptionPane.showMessageDialog(this, "Old password is incorrect!");
            //             return;
            //         }

            //         // Update password
            //         stmtUpdate.setString(1, newPassword);
            //         // stmtUpdate.setInt(2, Login.userId);
            //         stmtUpdate.executeUpdate();
            //         JOptionPane.showMessageDialog(this, "Password updated successfully!");
            //         this.dispose();
            //         new ViewProfile();
            //     }
            // } catch (SQLException ex) {
            //     ex.printStackTrace();
            //     JOptionPane.showMessageDialog(this, "An error occurred while updating the password.");
            // } finally {
            //     conn.disconnect();
            // }
            // tambahin ke controler, jochal
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
        new BookTableForm();
    }
}

