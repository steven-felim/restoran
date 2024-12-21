package view.employee;

import view.employee.deliveryman.AcceptDeliveryOrder;
import view.employee.chef.ViewFnBStock;
import view.employee.cashier.ViewOrder;
import view.guest.Login;

import javax.swing.*;
import java.awt.*;

public class EmployeeMenu extends JFrame {
    public EmployeeMenu() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Employee Menu");

        JLabel title = new JLabel("Restoran HB");
        title.setBounds(290, 50, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 60, 1080, 600);

        JButton viewOrder = new JButton("View Order");
        viewOrder.setBounds(180, 150, 440, 40);
        panel.add(viewOrder);

        viewOrder.addActionListener(e -> {
            this.dispose();
            new ViewOrder();
        });

        JButton acceptDelivery = new JButton("Accept Delivery Order");
        acceptDelivery.setBounds(180, 200, 440, 40);
        panel.add(acceptDelivery);

        acceptDelivery.addActionListener(e -> {
            this.dispose();
            new AcceptDeliveryOrder();
        });

        JButton viewStock = new JButton("View F&B Stock");
        viewStock.setBounds(660, 150, 440, 40);
        panel.add(viewStock);

        viewStock.addActionListener(e -> {
            this.dispose();
            new ViewFnBStock();
        });

        JButton logout = new JButton("Logout");
        logout.setBounds(660, 200, 440, 40);
        panel.add(logout);

        logout.addActionListener(e -> {
            this.dispose();
            new Login();
        });

        add(title);
        add(panel);
    }

    public static void main(String[] args) {
        new EmployeeMenu();
    }
}
