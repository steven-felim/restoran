package view.guest.login;

import javax.swing.*;

import java.awt.*;

public class Register extends JFrame {
    public Register() {
        initComponents();
        this.setVisible(true);
    }

    public void initComponents() {
        this.setSize(400, 600);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Register!");

        JLabel screenTitle = new JLabel("Register");
        screenTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 44));
        screenTitle.setBounds(116, 22, 200, 51);

        JPanel formLogin = new JPanel();
        formLogin.setLayout(null);
        formLogin.setBounds(44, 80, 300, 350);

        JLabel usernameUser = new JLabel("Username:");
        usernameUser.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
        usernameUser.setBounds(5, 0, 130, 30);
        formLogin.add(usernameUser);

        JTextField usernameField = new JTextField(255);
        usernameField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        usernameField.setBounds(0, 33, 296, 30);
        formLogin.add(usernameField);

        JLabel emailUser = new JLabel("Email:");
        emailUser.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
        emailUser.setBounds(5, 66, 130, 30);
        formLogin.add(emailUser);

        JTextField emailField = new JTextField(255);
        emailField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        emailField.setBounds(0, 99, 296, 30);
        formLogin.add(emailField);

        JLabel passwordUser = new JLabel("Password:");
        passwordUser.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
        passwordUser.setBounds(5, 140, 130, 30);
        formLogin.add(passwordUser);

        JTextField passwordField = new JTextField(255);
        passwordField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        passwordField.setBounds(0, 170, 296, 30);
        formLogin.add(passwordField);

        JLabel phoneUser = new JLabel("Phone:");
        phoneUser.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
        phoneUser.setBounds(5, 210, 130, 30);
        formLogin.add(phoneUser);

        JTextField phoneField = new JTextField(255);
        phoneField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        phoneField.setBounds(0, 240, 296, 30);
        formLogin.add(phoneField);

        JLabel walletPinUser = new JLabel("Wallet Pin:");
        walletPinUser.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
        walletPinUser.setBounds(5, 280, 130, 30);
        formLogin.add(walletPinUser);

        JTextField pinField = new JTextField(10);
        pinField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        pinField.setBounds(0, 310, 296, 30);
        formLogin.add(pinField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(86, 450, 350, 100);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(0, 0, 100, 40);
        buttonPanel.add(registerButton);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(110, 0, 100, 40);
        buttonPanel.add(loginButton);

        loginButton.addActionListener(e -> {
            this.dispose();
            new Login();
        });

        add(screenTitle);
        add(formLogin);
        add(buttonPanel);
    }

    public static void main(String[] args) {
        new Register();
    }
}