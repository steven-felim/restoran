package view.member.transaction_member;

import view.member.MemberMenu;

import javax.swing.*;

public class AddWallet extends JFrame {
    private JTextField amountField;
    private JPasswordField pinField;
    private JButton addButton;
    private JLabel balanceLabel;
    private AddWallet wallet;

    public AddWallet() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("Wallet Management");
        setSize(400, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        // Balance Label
        balanceLabel = new JLabel("Current Balance: $" + wallet);
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
        addButton.setBounds(10, 140, 150, 25);
        panel.add(addButton);

        JButton profileButton = new JButton("Back");
        profileButton.setBounds(200, 140, 150, 25);
        panel.add(profileButton);

        profileButton.addActionListener(e -> {
            this.dispose();
            new MemberMenu();
        });

    }

    public static void main(String[] args) {
        new AddWallet();
    }
}

