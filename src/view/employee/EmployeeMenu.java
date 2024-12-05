package view.employee;

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

        JButton confirmOrder = new JButton("Confirm Order");
        confirmOrder.setBounds(180, 100, 440, 40);
        panel.add(confirmOrder);

        JButton viewOrder = new JButton("View Order");
        viewOrder.setBounds(180, 150, 440, 40);
        panel.add(viewOrder);

        JButton acceptDelivery = new JButton("Accept Delivery Order");
        acceptDelivery.setBounds(180, 200, 440, 40);
        panel.add(acceptDelivery);

        JButton viewStock = new JButton("View F&B Stock");
        viewStock.setBounds(660, 100, 440, 40);
        panel.add(viewStock);

        JButton addStock = new JButton("Add F&B Stock");
        addStock.setBounds(660, 150, 440, 40);
        panel.add(addStock);

        add(title);
        add(panel);
    }

    public static void main(String[] args) {
        new EmployeeMenu();
    }
}

