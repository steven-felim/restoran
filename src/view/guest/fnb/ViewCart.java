package view.guest.fnb;

import controller.FnBController;
import model.classes.Cart;
import model.classes.FoodAndBeverage;
import view.guest.GuestMenu;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewCart extends JFrame {
    private Cart cart;
    private FnBController fnbc;

    public ViewCart() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Cart Summary");

        JLabel title = new JLabel("Your FnB Order");
        title.setBounds(500, 0, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 100, 880, 700);

        // Show cart details and total price
        JTextArea cartDetails = new JTextArea();
        cartDetails.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        cartDetails.setBounds(10, 50, 1245, 300);
        cartDetails.setEditable(false);

        StringBuilder cartContent = new StringBuilder();
        double totalPrice = 0;

        // for (FoodAndBeverage fnb : cart.getItems()) {
        //     cartContent.append(fnb.getName()).append(" x").append(fnb.getQuantity())
        //             .append(" - ").append(fnb.getPrice()).append("\n");
        //     totalPrice += fnb.getPrice() * fnb.getQuantity();
        // }

        cartContent.append("\nTotal Price: ").append(totalPrice);
        cartDetails.setText(cartContent.toString());

        panel.add(cartDetails);

        // Choose Delivery or Pick-up
        JLabel methodLabel = new JLabel("Choose a method to collect your order:");
        methodLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        methodLabel.setBounds(200, 360, 600, 30);
        panel.add(methodLabel);

        JButton deliveryButton = new JButton("Delivery");
        deliveryButton.setBounds(200, 400, 200, 40);
        panel.add(deliveryButton);

        JButton pickUpButton = new JButton("Pick Up at Restaurant");
        pickUpButton.setBounds(450, 400, 250, 40);
        panel.add(pickUpButton);

        // Button Actions
        deliveryButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "You have chosen delivery. Please enter your address.");
            new DeliveryMenu(); 
            this.dispose();
        });

        pickUpButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "You have chosen pick-up. A receipt will be generated.");
            generateReceipt();  
            this.dispose();
            new ViewCart();
        });

        JButton orderButton = new JButton("order menu");
        orderButton.setBounds(1050, 10, 100, 30);
        orderButton.addActionListener(e -> {
            this.dispose();
            new ViewOrderFAndBGuest(); 
        });
        panel.add(orderButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 10, 100, 30);
        backButton.addActionListener(e -> {
            this.dispose();
            new GuestMenu(); 
        });
        panel.add(backButton);

        this.add(title);
        this.add(panel);
    }

    //Method to generate receipt for pick-up option
    private void generateReceipt() {
        StringBuilder receiptContent = new StringBuilder();
        double totalPrice = 0;

        // receiptContent.append("Restaurant Receipt\n\n");
        // for (FoodAndBeverage fnb : cart.getItems()) {
        //     receiptContent.append(fnb.getName()).append(" x").append(fnb.getQuantity())
        //             .append(" - ").append(fnb.getPrice()).append("\n");
        //     totalPrice += fnb.getPrice() * fnb.getQuantity();
        // }

        receiptContent.append("\nTotal Price: ").append(totalPrice);
        receiptContent.append("\n\nThank you for your order! Please pick up your food at the restaurant.");

        JTextArea receiptTextArea = new JTextArea();
        receiptTextArea.setText(receiptContent.toString());
        receiptTextArea.setEditable(false);
        receiptTextArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));

        JOptionPane.showMessageDialog(this, new JScrollPane(receiptTextArea), "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new ViewCart();
    }
}

