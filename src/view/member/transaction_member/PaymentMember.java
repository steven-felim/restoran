package view.member.transaction_member;

import model.classes.Cart;
import model.classes.Wallet;
import view.member.MemberMenu;

import javax.swing.*;
import java.awt.*;

public class PaymentMember extends JFrame {
    private Wallet wallet;
    private Cart cart;
    private JLabel totalLabel;
    private JLabel balanceLabel;
    private int userPoints;

    public PaymentMember() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("Payment");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        JLabel titleLabel = new JLabel("Payment");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        titleLabel.setBounds(150, 10, 200, 30);
        panel.add(titleLabel);

        totalLabel = new JLabel("Total: Rp " ); 
        totalLabel.setBounds(20, 60, 200, 25);
        panel.add(totalLabel);

        balanceLabel = new JLabel("Your Balance: Rp ");
        balanceLabel.setBounds(20, 100, 200, 25);
        panel.add(balanceLabel);

        JButton payButton = new JButton("Pay Now");
        payButton.setBounds(50, 150, 100, 30);
        panel.add(payButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 150, 100, 30);
        panel.add(cancelButton);

        payButton.addActionListener(e -> processPayment());
        cancelButton.addActionListener(e -> {
            dispose();
            new MemberMenu();
        });
    }

    private void processPayment() {
    //     if (wallet.getBalance() < cart.getTotal()) {
    //         JOptionPane.showMessageDialog(this, "Insufficient balance!");
    //         return;
    //     }

        // // Calculate points if the total exceeds Rp 10,000
        // if (cart.getTotal() > 10000) {
        //     int pointsEarned = cart.getTotal() / 1000; // 1 point for every Rp 1,000 spent
        //     userPoints += pointsEarned;
        //     updateUserPointsInDatabase(wallet.getUserId(), userPoints);
        //     JOptionPane.showMessageDialog(this, "Payment successful! You earned " + pointsEarned + " points.");
        // } else {
        //     JOptionPane.showMessageDialog(this, "Payment successful! No points earned for purchases below Rp 10,000.");
        // }

        // // Save the transaction to the database
        // saveTransaction();

        // // Close the window and return to the menu
        // dispose();
        // new MemberMenu();
    }

    public static void main(String[] args) {
        new PaymentMember(); 
    }
}
