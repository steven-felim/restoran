package view.member.menu_member.transaction_member;

import model.classes.Wallet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wallet extends JFrame {
    private JTextField amountField;
    private JPasswordField pinField;
    private JButton addButton;
    private JLabel balanceLabel;
    private Wallet wallet;

    public Wallet(Wallet wallet) {
        this.wallet = wallet;
        initComponents();
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
        addButton.setBounds(10, 110, 150, 25);
        panel.add(addButton);

    }

    public static void main(String[] args) {
        new Wallet();
    }
}

