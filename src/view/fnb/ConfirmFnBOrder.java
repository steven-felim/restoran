package view.fnb;

import controller.AuthenticationController;
import controller.FnBController;
import model.classes.Cart;
import model.classes.FoodAndBeverage;
import view.employee.cashier.CashierMenu;
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
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            setVisible(true);
        }
    }

    private void initComponents() {
        fnbc = new FnBController();
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Confirm Order");

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(null);
        topPanel.setBounds(0, 0, 900, 100);

        JLabel title = new JLabel("Confirm Order");
        title.setBounds(340, 0, 220, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JButton backButton = new JButton("Back to Main Menu");
        backButton.setBounds(25, 20, 150, 30);

        backButton.addActionListener(e -> {
            JOptionPane.showConfirmDialog(null, "Are you sure to cancel your order?", "Confirm Order", JOptionPane.OK_CANCEL_OPTION);
            if ("Member".equalsIgnoreCase(origin)) {
                this.dispose();
                new MemberMenu();
            } else if ("Cashier".equalsIgnoreCase(origin)) {
                this.dispose();
                new CashierMenu();
            }
        });

        topPanel.add(backButton);
        topPanel.add(title);
        this.add(topPanel);

        List<FoodAndBeverage> cartItems = fnbc.getAllFnb();
        // nanti list fnb diganti jadi list cart

        JPanel cartPanel = new JPanel();
        cartPanel.setBackground(Color.WHITE);
        cartPanel.setLayout(null);
        cartPanel.setPreferredSize(new Dimension(600, cartItems.size() * 40));

        for (int i = 0; i < cartItems.size(); i++) {
            FoodAndBeverage item = cartItems.get(i);

            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(null);
            itemPanel.setBounds(0, i * 40, 600, 40);

            JLabel itemNameLabel = new JLabel(item.getName() + " - Rp " + item.getPrice());
            itemNameLabel.setBounds(0, 0, 540, 40);

            JLabel quantity = new JLabel("1");
            quantity.setBounds(540, 0, 60, 40);

            itemPanel.add(itemNameLabel);
            itemPanel.add(quantity);

            cartPanel.add(itemPanel);
        }

        JScrollPane scrollPane = new JScrollPane(cartPanel);
        scrollPane.setBounds(0, 100, 600, 400);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(scrollPane);

        JPanel voucherPanel = new JPanel();
        voucherPanel.setBackground(Color.WHITE);
        voucherPanel.setLayout(null);
        voucherPanel.setBounds(600, 100, 300, 133);

        JLabel voucherLabel = new JLabel("Voucher");
        voucherLabel.setBounds(100, 0, 100, 40);
        voucherLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        voucherPanel.add(voucherLabel);
        JComboBox voucherComboBox = new JComboBox<>();
        voucherComboBox.setBounds(20, 60, 250, 30); // get voucher_claim dari db
        voucherPanel.add(voucherComboBox);
        this.add(voucherPanel);

        JPanel paymentMethod = new JPanel();
        paymentMethod.setBackground(Color.WHITE);
        paymentMethod.setLayout(null);
        paymentMethod.setBounds(600, 233, 300, 197);

        JLabel paymentLabel = new JLabel("Payment Method");
        paymentLabel.setBounds(70, 0, 200, 40);
        paymentLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        ButtonGroup payment = new ButtonGroup();

        JRadioButton cash =  new JRadioButton("Cash");
        cash.setBackground(Color.WHITE);
        cash.setBounds(25, 45, 100, 30);
        payment.add(cash);

        JRadioButton wallet = new JRadioButton("Wallet");
        wallet.setBackground(Color.WHITE);
        wallet.setBounds(25, 75, 100, 30);
        payment.add(wallet);

        JLabel walletBalance = new JLabel("Balance: Rp"); // tampilkan saldo dari controller
        walletBalance.setBounds(25, 105, 150, 30);
        walletBalance.setVisible(false);

        wallet.addActionListener(e -> {
            if (wallet.isSelected()) {
                if ("Cashier".equalsIgnoreCase(origin)) {
                    JOptionPane.showInputDialog("Input member's cellphone number:");
                    // if nomor telepon ada -> tampilkan saldo member
                }
                walletBalance.setVisible(true);
            }
        });

        cash.addActionListener(e -> {
            if (cash.isSelected()) {
                walletBalance.setVisible(false);
            }
        });

        paymentMethod.add(walletBalance);
        paymentMethod.add(paymentLabel);
        paymentMethod.add(cash);
        paymentMethod.add(wallet);
        this.add(paymentMethod);

        JPanel totalPayment = new JPanel();
        totalPayment.setBackground(Color.WHITE);
        totalPayment.setLayout(null);
        totalPayment.setBounds(600, 430, 300, 70);

        JLabel totalLabel = new JLabel("Total Price:    Rp"); // tambahkan total harga cart melalui controller
        totalLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        totalLabel.setBounds(25, 10, 250, 50);
        totalPayment.add(totalLabel);
        this.add(totalPayment);

        JPanel orderTypePanel = new JPanel();
        orderTypePanel.setBackground(Color.WHITE);
        orderTypePanel.setBounds(0, 500, 600, 100);

        JLabel methodLabel = new JLabel("Choose a method to collect your order:");
        ButtonGroup orderMethod = new ButtonGroup();
        JRadioButton delivery = new JRadioButton("Delivery");
        delivery.setBackground(Color.WHITE);
        JRadioButton takeaway = new JRadioButton("Take Away");
        takeaway.setBackground(Color.WHITE);
        JRadioButton dinein = new JRadioButton("Dine In");
        dinein.setBackground(Color.WHITE);
        orderMethod.add(delivery);
        orderMethod.add(takeaway);
        orderMethod.add(dinein);

        orderTypePanel.add(methodLabel);
        if (!"Cashier".equalsIgnoreCase(origin)) {
            orderTypePanel.add(delivery);
        }
        orderTypePanel.add(takeaway);
        orderTypePanel.add(dinein);
        this.add(orderTypePanel);

        JPanel confirmPanel = new JPanel();
        confirmPanel.setBackground(Color.WHITE);
        confirmPanel.setLayout(null);
        confirmPanel.setBounds(600, 500, 300, 100);

        JButton confirmButton = new JButton("Checkout");
        confirmButton.setBounds(0, 0, 285, 60);
        confirmPanel.add(confirmButton);
        this.add(confirmPanel);

        revalidate();
        repaint();

        confirmButton.addActionListener(e -> {
            if (orderMethod.getSelection() == null) {
                JOptionPane.showMessageDialog(null, "Please select your order method", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (delivery.isSelected()) {
                JOptionPane.showMessageDialog(this, "You have chosen delivery. Please enter your address.");
                new DeliveryMenu();
                this.dispose();
            } else if (takeaway.isSelected()){
                JOptionPane.showMessageDialog(this, "You have chosen take away.");
                generateReceipt();
                if ("Member".equalsIgnoreCase(origin)) {
                    this.dispose();
                    new MemberMenu();
                } else if ("Cashier".equalsIgnoreCase(origin)) {
                    this.dispose();
                    new CashierMenu();
                }
            } else if (dinein.isSelected()){
                JOptionPane.showMessageDialog(this, "You have chosen dine in.");
                generateReceipt();
                if ("Member".equalsIgnoreCase(origin)) {
                    this.dispose();
                    new MemberMenu();
                } else if ("Cashier".equalsIgnoreCase(origin)) {
                    this.dispose();
                    new CashierMenu();
                }
            }
        });

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