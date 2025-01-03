package view.employee.cashier;

import controller.AuthenticationController;
import view.guest.login.Login;
import view.profile.ViewProfile;

import javax.swing.*;
import java.awt.*;

public class CashierMenu extends JFrame{
    public CashierMenu() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            setVisible(true);
        }
    }

    private void initComponents() {
        this.setSize(400, 360);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Cashier Menu");

        JLabel title = new JLabel("RHB - Cashier");
        title.setBounds(100, 22, 300, 51);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(44, 100, 300, 200);

        JButton viewOrder = new JButton("View Order");
        viewOrder.setBounds(0, 0, 300, 40);
        buttonPanel.add(viewOrder);

        viewOrder.addActionListener(e -> {
            this.dispose();
            new ViewOrder();
        });

        JButton orderFnB = new JButton("Order F&B Manually");
        orderFnB.setBounds(0, 50, 300, 40);
        buttonPanel.add(orderFnB);

        orderFnB.addActionListener(e -> {
            new OrderFnBCashier();
            this.dispose();
        });

        JButton acceptDelivery = new JButton("View Profile");
        acceptDelivery.setBounds(0, 100, 300, 40);
        buttonPanel.add(acceptDelivery);

        acceptDelivery.addActionListener(e -> {
            this.dispose();
            new ViewProfile();
        });

        JButton logout = new JButton("Logout");
        logout.setBounds(0, 150, 300, 40);
        buttonPanel.add(logout);

        logout.addActionListener(e -> {
            this.dispose();
            new Login();
        });

        add(title);
        add(buttonPanel);
    }

    public static void main(String[] args) {
        new CashierMenu();
    }
}
