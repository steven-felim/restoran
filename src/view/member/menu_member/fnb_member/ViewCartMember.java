package view.member.menu_member.fnb_member;

import model.classes.Cart;
import model.classes.FoodAndBeverage;
import view.member.MemberMenu;
import view.member.menu_member.transaction_member.DeliveryMember;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ViewCartMember extends JFrame {
    private Cart cart;

    public ViewCartMember() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.setTitle("View Cart");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Top Panel with back button
        JPanel topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setPreferredSize(new Dimension(600, 75));

        JButton backButton = new JButton("Back to Main Menu");
        backButton.setBounds(25, 10, 150, 30);
        backButton.addActionListener(e -> {
            this.dispose();
            new MemberMenu(); 
        });

        JLabel title = new JLabel("Your Cart");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        title.setBounds(200, 10, 300, 30);

        topPanel.add(backButton);
        topPanel.add(title);

        this.add(topPanel, BorderLayout.NORTH);

        // Cart details panel
        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));

        // Display the cart items
        // Map<FoodAndBeverage, Integer> items = cart.getItems();
        // if (items.isEmpty()) {
        //     cartPanel.add(new JLabel("Your cart is empty."));
        // } else {
        //     for (Map.Entry<FoodAndBeverage, Integer> entry : items.entrySet()) {
        //         FoodAndBeverage item = entry.getKey();
        //         int quantity = entry.getValue();
        //         JPanel itemPanel = new JPanel();
        //         itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        //         JLabel itemNameLabel = new JLabel(item.getName() + " - " + quantity + " pcs - Rp " + (item.getPrice() * quantity));
        //         itemPanel.add(itemNameLabel);

        //         cartPanel.add(itemPanel);
        //     }
        // }

        JScrollPane cartScrollPane = new JScrollPane(cartPanel);
        this.add(cartScrollPane, BorderLayout.CENTER);

        // Bottom panel with Proceed to Checkout button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton proceedButton = new JButton("Proceed to Checkout");
        proceedButton.addActionListener(e -> {
            this.dispose();
            new DeliveryMember();  
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Order cancelled.");
            // cart.clearCart(); 
            this.dispose();
        });

        bottomPanel.add(proceedButton);
        bottomPanel.add(cancelButton);

        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new ViewCartMember();
    }
}

