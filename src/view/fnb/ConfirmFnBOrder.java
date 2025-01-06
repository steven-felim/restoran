package view.fnb;

import controller.FnBController;
import model.classes.Cart;
import model.classes.FoodAndBeverage;
import view.employee.cashier.CashierMenu;
import view.guest.GuestMenu;
import view.member.MemberMenu;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ConfirmFnBOrder extends JFrame {
    private String origin;
    private Cart cart;
    private FnBController fnbc;

    public ConfirmFnBOrder(String origin) {
        this.origin = origin;
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        fnbc = new FnBController();
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Confirm Order");

        JLabel title = new JLabel("Confirm Order");
        title.setBounds(200, 0, 250, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(null);
        topPanel.setPreferredSize(new Dimension(600, 75));

        JButton backButton = new JButton("Back to Main Menu");
        backButton.setBounds(25, 10, 150, 30);

        backButton.addActionListener(e -> {
            if ("Member".equalsIgnoreCase(origin)) {
                this.dispose();
                new MemberMenu();
            } else if ("Guest".equalsIgnoreCase(origin)) {
                this.dispose();
                new GuestMenu();
            } else if ("Cashier".equalsIgnoreCase(origin)) {
                this.dispose();
                new CashierMenu();
            }
        });

        topPanel.add(backButton);
        topPanel.add(title);

        this.add(topPanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        List<FoodAndBeverage> menuItems = fnbc.getAllFnb();
        // nanti list fnb diganti jadi list cart

        for (FoodAndBeverage item : menuItems) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, 5, 5, 5);

            JLabel itemNameLabel = new JLabel(item.getName() + " - Rp " + item.getPrice());
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            itemPanel.add(itemNameLabel, gbc);

            JPanel quantityPanel = new JPanel();
            quantityPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel quantity = new JLabel("1");
            quantityPanel.add(quantity);
            // jumlah yg dipesan menyesuaikan cart & otomatis terisi di text field

            gbc.gridx = 2;
            gbc.weightx = 0.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            itemPanel.add(quantityPanel, gbc);
            mainPanel.add(itemPanel);
        }
        JLabel totalLabel = new JLabel("Total Price:    Rp"); // tambahkan total harga cart melalui controller
        mainPanel.add(totalLabel);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Choose Delivery or Pick-up
        JLabel methodLabel = new JLabel("Choose a method to collect your order:");
        methodLabel.setBounds(200, 360, 600, 30);
        bottomPanel.add(methodLabel);

        if (!"Cashier".equalsIgnoreCase(origin)) {
            JButton deliveryButton = new JButton("Delivery");
            bottomPanel.add(deliveryButton);

            deliveryButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "You have chosen delivery. Please enter your address.");
                new DeliveryMenu(origin);
                this.dispose();
            });
        }

        JButton takeAwayButton = new JButton("Take Away");
        bottomPanel.add(takeAwayButton);

        takeAwayButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "You have chosen take away. A receipt will be generated.");
            generateReceipt();
            if ("Member".equalsIgnoreCase(origin)) {
                this.dispose();
                new MemberMenu();
            } else if ("Guest".equalsIgnoreCase(origin)) {
                this.dispose();
                new GuestMenu();
            } else if ("Cashier".equalsIgnoreCase(origin)) {
                this.dispose();
                new CashierMenu();
            }
        });

        JButton dineInButton = new JButton("Dine In");
        bottomPanel.add(dineInButton);

        dineInButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "You have chosen dine in.");
            generateReceipt();
            if ("Member".equalsIgnoreCase(origin)) {
                this.dispose();
                new MemberMenu();
            } else if ("Guest".equalsIgnoreCase(origin)) {
                this.dispose();
                new GuestMenu();
            } else if ("Cashier".equalsIgnoreCase(origin)) {
                this.dispose();
                new CashierMenu();
            }
        });

        this.add(bottomPanel, BorderLayout.SOUTH);
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
}