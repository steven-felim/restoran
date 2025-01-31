package view.profile;

import controller.*;
import model.classes.NonGuest;

import javax.swing.*;
import java.awt.*;

public class EditProfile extends JFrame {
    private String originClass; // simpan origin dengan Design Pattern Memento
    private NonGuest user;
    private UserController uc;

    public EditProfile(String originClass) {
        this.originClass = originClass;
        uc = new UserController();
        user = uc.getDataFromDB(AuthenticationHelper.getInstance().getRoleId());
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            this.setVisible(true);
        }
    }

    private void initComponents() {
        this.setSize(400, 600);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Edit Profile");
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("Edit Profile");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        title.setBounds(120, 22, 300, 51);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setLayout(null);
        formPanel.setBounds(44, 111, 300, 250);

        JLabel name = new JLabel("Username:");
        name.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        name.setBounds(115, 0, 130, 30);
        formPanel.add(name);

        JTextField nameField = new JTextField(user.getName(), 255);
        nameField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        nameField.setBounds(0, 33, 298, 30);
        formPanel.add(nameField);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        email.setBounds(125, 77, 130, 30);
        formPanel.add(email);

        JTextField emailField = new JTextField(user.getEmail(), 255);
        emailField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        emailField.setBounds(0, 110, 298, 30);
        formPanel.add(emailField);

        JLabel phone = new JLabel("Phone Number:");
        phone.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        phone.setBounds(95, 153, 180, 30);
        formPanel.add(phone);

        JTextField phoneField = new JTextField(user.getCellphone(), 255);
        phoneField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        phoneField.setBounds(0, 190, 298, 30);
        formPanel.add(phoneField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(43, 400, 350, 100);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(0, 0, 150, 40);
        buttonPanel.add(saveButton);

        saveButton.addActionListener(e -> {
            uc.editUserDetails(AuthenticationHelper.getInstance().getRoleId(), nameField.getText(), emailField.getText(), phoneField.getText());
            JOptionPane.showMessageDialog(null, "Data successfully updated!");
            this.dispose();
            new ViewProfile(originClass);
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150, 0, 150, 40);
        buttonPanel.add(cancelButton);

        cancelButton.addActionListener(e -> {
            this.dispose();
            new ViewProfile(originClass);
        });

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(title);
        add(formPanel);
        add(buttonPanel);
    }
}