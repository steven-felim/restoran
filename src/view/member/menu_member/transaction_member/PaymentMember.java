package view.member.menu_member.transaction_member;

import model.classes.Cart;
import model.classes.Wallet;
import view.member.MemberMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentMember extends JFrame {
    private Wallet wallet;
    private Cart cart;
    private JLabel totalLabel;
    private JLabel balanceLabel;

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

        totalLabel = new JLabel("Total: Rp " + cart); 
        totalLabel.setBounds(20, 60, 200, 25);
        panel.add(totalLabel);

        balanceLabel = new JLabel("Your Balance: Rp " + wallet);
        balanceLabel.setBounds(20, 100, 200, 25);
        panel.add(balanceLabel);

        JButton payButton = new JButton("Pay Now");
        payButton.setBounds(50, 150, 100, 30);
        panel.add(payButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 150, 100, 30);
        panel.add(cancelButton);


        cancelButton.addActionListener(e -> {
            dispose();
            new MemberMenu();
        });
    }

    public static void main(String[] args) {
        new PaymentMember();
    }
}

