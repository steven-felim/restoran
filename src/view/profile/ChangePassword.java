package view.profile;

import controller.AuthenticationController;
import controller.PasswordToggleCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePassword extends JFrame {
    private String originClass; // simpan origin dengan Design Pattern Memento

    public ChangePassword(String originClass) {
        this.originClass = originClass;
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
        formPass.setBackground(Color.WHITE);
        formPass.setLayout(null);
        formPass.setBounds(44, 111, 300, 250);

        JLabel oldPass = new JLabel("Old Password:");
        oldPass.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        oldPass.setBounds(95, 0, 130, 30);
        formPass.add(oldPass);

        JPasswordField oldPassField = new JPasswordField(255);
        oldPassField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        oldPassField.setBounds(0, 33, 248, 30);
        oldPassField.setEchoChar('*');
        formPass.add(oldPassField);

        JButton oldPassButton = new JButton("-");
        oldPassButton.setBounds(248, 33, 50, 30);
        formPass.add(oldPassButton);

        PasswordToggleCommand command1 = new PasswordToggleCommand(oldPassButton, new JPasswordField[]{oldPassField});

        oldPassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command1.execute();
            }
        });

        JLabel newPass = new JLabel("New Password:");
        newPass.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        newPass.setBounds(95, 77, 130, 30);
        formPass.add(newPass);

        JPasswordField newPassField = new JPasswordField(255);
        newPassField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        newPassField.setBounds(0, 110, 248, 30);
        newPassField.setEchoChar('*');
        formPass.add(newPassField);

        JButton newPassButton = new JButton("-");
        newPassButton.setBounds(248, 110, 50, 30);
        formPass.add(newPassButton);

        PasswordToggleCommand command2 = new PasswordToggleCommand(newPassButton, new JPasswordField[]{newPassField});

        newPassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command2.execute();
            }
        });

        JLabel confirmPass = new JLabel("Confirm New Password:");
        confirmPass.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        confirmPass.setBounds(55, 153, 180, 30);
        formPass.add(confirmPass);

        JPasswordField confirmPassField = new JPasswordField(255);
        confirmPassField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        confirmPassField.setBounds(0, 190, 248, 30);
        confirmPassField.setEchoChar('*');
        formPass.add(confirmPassField);

        JButton confirmPassButton = new JButton("-");
        confirmPassButton.setBounds(248, 190, 50, 30);
        formPass.add(confirmPassButton);

        PasswordToggleCommand command3 = new PasswordToggleCommand(confirmPassButton, new JPasswordField[]{confirmPassField});

        confirmPassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                command3.execute();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(43, 400, 350, 100);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(0, 0, 150, 40);
        buttonPanel.add(resetButton);

        resetButton.addActionListener(e -> {
            // logic save password ke DB
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150, 0, 150, 40);
        buttonPanel.add(cancelButton);

        cancelButton.addActionListener(e -> {
            this.dispose();
            new ViewProfile(originClass);
        });

        add(title);
        add(formPass);
        add(buttonPanel);
    }
}