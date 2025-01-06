package view.profile;

import controller.AuthenticationController;
import view.employee.cashier.CashierMenu;
import view.employee.chef.ChefMenu;
import view.employee.deliveryman.DeliverymanMenu;
import view.employee.waiter.WaiterMenu;
import view.member.MemberMenu;

import javax.swing.*;
import java.awt.*;

public class ViewProfile extends JFrame {
    private String originClass; // simpan origin dengan Design Pattern Memento

    public ViewProfile(String originClass) {
        this.originClass = originClass;
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            this.setVisible(true);
        }
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

        JPanel profilePanel = new JPanel();
        profilePanel.setBackground(Color.WHITE);
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

        if ("Member".equals(originClass)) {
            profilePanel.add(new JLabel("Wallet Balance:"));
            JLabel walletLabel = new JLabel("Rp" + walletBalance);
            profilePanel.add(walletLabel);
        }

        add(profilePanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton changePasswordButton = new JButton("Change Password");
        JButton editProfileButton = new JButton("Edit Profile");
        JButton backButton = new JButton("Back");

        changePasswordButton.addActionListener(e -> {
            this.dispose();
            new ChangePassword(originClass);
        });

        editProfileButton.addActionListener(e -> {
            this.dispose();
            new EditProfile(originClass);
        });

        backButton.addActionListener(e -> {
            if ("Member".equalsIgnoreCase(originClass)) {
                this.dispose();
                new MemberMenu();
            } else if ("Cashier".equalsIgnoreCase(originClass)) {
                this.dispose();
                new CashierMenu();
            } else if ("Chef".equalsIgnoreCase(originClass)) {
                this.dispose();
                new ChefMenu();
            } else if ("Deliveryman".equalsIgnoreCase(originClass)) {
                this.dispose();
                new DeliverymanMenu();
            } else if ("Waiter".equalsIgnoreCase(originClass)) {
                this.dispose();
                new WaiterMenu();
            }
        });

        buttonPanel.add(changePasswordButton);
        buttonPanel.add(editProfileButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
