package view.member.transaction_member;

import controller.AuthenticationController;
import controller.AuthenticationHelper;
import controller.MemberController;
import controller.WalletController;
import view.member.MemberMenu;

import java.awt.Color;

import javax.swing.*;

public class AddWallet extends JFrame {
    private JTextField amountField;
    private JPasswordField pinField;
    private JButton addButton;
    private JLabel balanceLabel;

    public AddWallet() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            setVisible(true);
        }
    }

    private void initComponents() {
        setTitle("Wallet Management");
        setSize(400, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        add(panel);
        panel.setLayout(null);

        // Balance Label
        balanceLabel = new JLabel(
        "Current Balance: Rp" + new WalletController().getWalletMember().getBalance()
        );
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

        addButton.addActionListener(e -> {
            boolean result = new WalletController().addBalanceMember(
                    amountField.getText(),
                    new String(pinField.getPassword())
            );
            if (result) {
                amountField.setText("");
                pinField.setText("");
                balanceLabel.setText(
                    "Current Balance: Rp" +
                    new WalletController().getWalletMember().getBalance()
                );
            }
        });

        profileButton.addActionListener(e -> {
            this.dispose();
            new MemberMenu();
        });

    }

    public static void main(String[] args) {
        new AddWallet();
    }
}

