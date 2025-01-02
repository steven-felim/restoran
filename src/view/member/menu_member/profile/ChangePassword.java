package view.member.menu_member.profile;

import controller.AuthenticationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword extends JFrame {
    public ChangePassword() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            setVisible(true);
        }
    }

    private void initComponents() {
        this.setSize(400, 600);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Change Password");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("Change Password");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        title.setBounds(50, 22, 300, 51);

        JPanel formPass = new JPanel();
        formPass.setLayout(null);
        formPass.setBounds(44, 111, 300, 250);

        JLabel oldPass = new JLabel("Old Password:");
        oldPass.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        oldPass.setBounds(95, 0, 130, 30);
        formPass.add(oldPass);

        JPasswordField oldPassField = new JPasswordField(255);
        oldPassField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        oldPassField.setBounds(0, 33, 298, 30);
        oldPassField.setEchoChar('*');
        formPass.add(oldPassField);

        JLabel newPass = new JLabel("New Password:");
        newPass.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        newPass.setBounds(95, 77, 130, 30);
        formPass.add(newPass);

        JPasswordField newPassField = new JPasswordField(255);
        newPassField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        newPassField.setBounds(0, 110, 298, 30);
        newPassField.setEchoChar('*');
        formPass.add(newPassField);

        JLabel confirmPass = new JLabel("Confirm New Password:");
        confirmPass.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        confirmPass.setBounds(55, 153, 180, 30);
        formPass.add(confirmPass);

        JPasswordField confirmPassField = new JPasswordField(255);
        confirmPassField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        confirmPassField.setBounds(0, 190, 298, 30);
        confirmPassField.setEchoChar('*');
        formPass.add(confirmPassField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(43, 400, 350, 100);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(0, 0, 100, 40);
        buttonPanel.add(resetButton);

        resetButton.addActionListener(e -> {
            // logic save password ke DB
        });

        JButton showButton = new JButton("Show Pass");
        showButton.setBounds(100, 0, 100, 40);
        buttonPanel.add(showButton);

        showButton.addActionListener(new ActionListener() {
            private boolean isPasswordVisible = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPasswordVisible) {
                    confirmPassField.setEchoChar('*');
                    showButton.setText("Show Pass");
                } else {
                    confirmPassField.setEchoChar((char) 0);
                    showButton.setText("Hide Pass");
                }
                isPasswordVisible = !isPasswordVisible;
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 0, 100, 40);
        buttonPanel.add(cancelButton);

        cancelButton.addActionListener(e -> {
            this.dispose();
            new ViewProfile();
        });

        add(title);
        add(formPass);
        add(buttonPanel);
    }
}