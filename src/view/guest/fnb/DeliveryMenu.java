package view.guest.fnb;

import model.classes.Cart;
import view.guest.GuestMenu;
import javax.swing.*;
import java.awt.*;

public class DeliveryMenu extends JFrame {
    private Cart cart;

    public DeliveryMenu() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.setTitle("Delivery Menu");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBackground(Color.WHITE);
        topPanel.setPreferredSize(new Dimension(600, 75));

        JButton backButton = new JButton("Back");
        backButton.setBounds(25, 10, 150, 30);
        backButton.addActionListener(e -> {
            this.dispose();
            new ConfirmFnBOrder();
        });

        JLabel title = new JLabel("Delivery Order");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        title.setBounds(200, 10, 300, 30);

        topPanel.add(backButton);
        topPanel.add(title);

        this.add(topPanel, BorderLayout.NORTH);

        // Delivery address 
        JPanel addressPanel = new JPanel();
        addressPanel.setBackground(Color.WHITE);
        addressPanel.setLayout(null);

        JLabel addressLabel = new JLabel("Enter Delivery Address:");
        addressLabel.setBounds(25, 50, 200, 25);
        addressPanel.add(addressLabel);

        JTextArea addressArea = new JTextArea();
        addressArea.setBounds(25, 80, 550, 100);
        addressArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);
        addressPanel.add(addressArea);

        this.add(addressPanel, BorderLayout.CENTER);

        // Bottom panel with Place Order and Cancel buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.addActionListener(e -> {
            String address = addressArea.getText().trim();
            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid delivery address.");
            } else {
                JOptionPane.showMessageDialog(this, "Order placed successfully! Your order will be delivered to: " + address);;
                this.dispose();
                new GuestMenu();
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Order cancelled.");
            this.dispose();
            new GuestMenu();
        });

        bottomPanel.add(placeOrderButton);
        bottomPanel.add(cancelButton);

        this.add(bottomPanel, BorderLayout.SOUTH);
    }
}