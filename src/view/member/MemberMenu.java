package view.member;

import javax.swing.*;

import view.guest.Login;
import view.guest.booktable.ViewCancelTableGuest;
import view.member.menu_member.BookTableForm;
import view.member.menu_member.EditProfile;
import view.member.menu_member.RescheduleTable;
import view.member.menu_member.ViewProfile;
import view.member.menu_member.ViewTableOrder;

import java.awt.*;

public class MemberMenu extends JFrame {
    public MemberMenu() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Guest Menu");

        JLabel title = new JLabel("Welcome, Member!");
        title.setBounds(500, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 60, 1080, 600);

        JButton bookTableButton = new JButton("Book Table");
        bookTableButton.setBounds(180, 100, 440, 40);
        panel.add(bookTableButton);

        bookTableButton.addActionListener(e -> {
            this.dispose();
            new BookTableForm();
        });

        JButton rescheduleTableButton = new JButton("Reschedule Table");
        rescheduleTableButton.setBounds(180, 150, 440, 40);
        panel.add(rescheduleTableButton);

        rescheduleTableButton.addActionListener(e -> {
            this.dispose();
            new RescheduleTable();
        });

        JButton cancelTableButton = new JButton("Cancel Table");
        cancelTableButton.setBounds(180, 200, 440, 40);
        panel.add(cancelTableButton);

        bookTableButton.addActionListener(e -> {
            this.dispose();
            new ViewCancelTableGuest();
        });

        JButton walletButton = new JButton("Wallet");
        walletButton.setBounds(180, 250, 440, 40);
        panel.add(walletButton);

        JButton profileButton = new JButton("Profile");
        profileButton.setBounds(180, 300, 440, 40);
        panel.add(profileButton);

        profileButton.addActionListener(e -> {
            this.dispose();
            new ViewProfile();
        });

        JButton viewTableOrder = new JButton("View Table Order");
        viewTableOrder.setBounds(660, 100, 440, 40);
        panel.add(viewTableOrder);

        viewTableOrder.addActionListener(e -> {
            this.dispose();
            new ViewTableOrder();
        });

        JButton orderMenuButton = new JButton("Order F&B Menu");
        orderMenuButton.setBounds(660, 150, 440, 40);
        panel.add(orderMenuButton);

        JButton viewCartButton = new JButton("Cart");
        viewCartButton.setBounds(660, 200, 440, 40);
        panel.add(viewCartButton);

        JButton editProfile = new JButton("Edit Profile Details");
        editProfile.setBounds(660, 200, 440, 40);
        panel.add(editProfile);

        editProfile.addActionListener(e -> {
            this.dispose();
            new EditProfile();
        });

        JButton viewPointButton = new JButton("View Point");
        viewPointButton.setBounds(660, 250, 440, 40);
        panel.add(viewPointButton);

        JButton logout = new JButton("Logout");
        logout.setBounds(660, 300, 440, 40);
        panel.add(logout);

        logout.addActionListener(e -> {
            this.dispose();
            new Login();
        });

        add(title);
        add(panel);
    }

    public static void main(String[] args) {
        new MemberMenu();
    }
}