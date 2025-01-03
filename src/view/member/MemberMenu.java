package view.member;

import javax.swing.*;

import controller.AuthenticationController;
import view.member.fnb.OrderFnB;
import view.member.table_member.BookTableForm;
import view.member.table_member.ViewTableMember;
import view.member.transaction_member.AddWallet;
import view.profile.ViewProfile;


import java.awt.*;

public class MemberMenu extends JFrame {
    public MemberMenu() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            this.setVisible(true);
        }
    }

    private void initComponents() {
        this.setSize(400, 560);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Member Menu");

        JLabel title = new JLabel("Welcome, Member!");
        title.setBounds(50, 30, 350, 40);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(44, 80, 300, 400);

        JButton bookTableButton = new JButton("Book Table");
        bookTableButton.setBounds(0, 0, 300, 40);
        panel.add(bookTableButton);

        bookTableButton.addActionListener(e -> {
            this.dispose();
            new BookTableForm();
        });

        JButton rescheduleTableButton = new JButton("View Book Table");
        rescheduleTableButton.setBounds(0, 50, 300, 40);
        panel.add(rescheduleTableButton);

        rescheduleTableButton.addActionListener(e -> {
            this.dispose();
            new ViewTableMember();
        });

        JButton walletButton = new JButton("Wallet");
        walletButton.setBounds(0, 100, 300, 40);
        panel.add(walletButton);

        walletButton.addActionListener(e -> {
            new AddWallet();
            this.dispose();
        });

        JButton profileButton = new JButton("Profile");
        profileButton.setBounds(0, 150, 300, 40);
        panel.add(profileButton);

        profileButton.addActionListener(e -> {
            this.dispose();
            new ViewProfile();
        });

        JButton orderMenuButton = new JButton("Order F&B Menu");
        orderMenuButton.setBounds(0, 200, 300, 40);
        panel.add(orderMenuButton);

        orderMenuButton.addActionListener(e -> {
            this.dispose();
            new OrderFnB();
        });

        JButton viewCartButton = new JButton("Cart");
        viewCartButton.setBounds(0, 250, 300, 40);
        panel.add(viewCartButton);

        JButton viewPointButton = new JButton("View Point");
        viewPointButton.setBounds(0, 300, 300, 40);
        panel.add(viewPointButton);

        JButton logout = new JButton("Logout");
        logout.setBounds(0, 350, 300, 40);
        panel.add(logout);

        logout.addActionListener(e -> {
            this.dispose();
            new AuthenticationController().logout();
        });

        add(title);
        add(panel);
    }

    public static void main(String[] args) {
        new MemberMenu();
    }
}