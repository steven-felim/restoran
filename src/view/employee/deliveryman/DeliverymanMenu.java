package view.employee.deliveryman;

import controller.AuthenticationController;
import view.guest.login.Login;
import view.profile.ViewProfile;

import javax.swing.*;
import java.awt.*;

public class DeliverymanMenu extends JFrame {
    public DeliverymanMenu() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            setVisible(true);
        }
    }

    private void initComponents() {
        this.setSize(400, 320);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Chef Menu");

        JLabel title = new JLabel("RHB - Deliveryman");
        title.setBounds(65, 22, 300, 51);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(44, 100, 300, 200);

        JButton viewStock = new JButton("Accept Delivery Order");
        viewStock.setBounds(0, 0, 300, 40);
        buttonPanel.add(viewStock);

        viewStock.addActionListener(e -> {
            this.dispose();
            new AcceptDeliveryOrder();
        });

        JButton acceptDelivery = new JButton("View Profile");
        acceptDelivery.setBounds(0, 50, 300, 40);
        buttonPanel.add(acceptDelivery);

        acceptDelivery.addActionListener(e -> {
            this.dispose();
            new ViewProfile("Deliveryman");
        });

        JButton logout = new JButton("Logout");
        logout.setBounds(0, 100, 300, 40);
        buttonPanel.add(logout);

        logout.addActionListener(e -> {
            this.dispose();
            new Login();
        });

        add(title);
        add(buttonPanel);
    }

    public static void main(String[] args) {
        new DeliverymanMenu();
    }
}
