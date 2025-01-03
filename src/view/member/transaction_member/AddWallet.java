package view.member.transaction_member;

import view.member.MemberMenu;

import javax.swing.*;

public class AddWallet extends JFrame {
    private JTextField amountField;
    private JPasswordField pinField;
    private JButton addButton, backButton;
    private JLabel balanceLabel;

    public AddWallet() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("Wallet Management");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create panel and layout
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        // Balance Label
        balanceLabel = new JLabel("Current Balance: Rp"); // tampilkan saldo melalui controller
        balanceLabel.setBounds(10, 20, 250, 25);
        panel.add(balanceLabel);
        
        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setBounds(10, 50, 100, 25);
        panel.add(amountLabel);
        
        amountField = new JTextField();
        amountField.setBounds(120, 50, 150, 25);
        panel.add(amountField);

        JLabel pinLabel = new JLabel("Enter PIN:");
        pinLabel.setBounds(10, 80, 100, 25);
        panel.add(pinLabel);

        pinField = new JPasswordField();
        pinField.setBounds(120, 80, 150, 25);
        panel.add(pinField);
        
        addButton = new JButton("Add Balance");
        addButton.setBounds(15, 110, 120, 25);
        panel.add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(150, 110, 120, 25);
        panel.add(backButton);

        backButton.addActionListener(e -> {
            new MemberMenu();
            this.dispose();
        });
    }

    public static void main(String[] args) {
        new AddWallet();
    }
}

