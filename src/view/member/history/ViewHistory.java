package view.member.history;

import javax.swing.*;

import view.profile.ViewProfile;

import java.awt.*;
    
public class ViewHistory extends JFrame {
    public ViewHistory() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.setSize(500, 620);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("History");

        JLabel title = new JLabel("Your History");
        title.setBounds(150, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 60, 400, 600);


        JButton bookTableHistoryButton = new JButton("Book Table History");
        bookTableHistoryButton.setBounds(110, 100, 250, 50);
        panel.add(bookTableHistoryButton);
        
        bookTableHistoryButton.addActionListener(e -> {
            this.dispose();
            new BookTableHistory();
        });

        JButton voucherPoinHistory = new JButton("Voucher Poin History");
        voucherPoinHistory.setBounds(110, 200, 250, 50);

        panel.add(voucherPoinHistory);
        voucherPoinHistory.addActionListener(e -> {
            this.dispose();
            new PoinHistory();
        });

        JButton transactionHistory = new JButton("Transaction History");
        transactionHistory.setBounds(110, 300, 250, 50);
        panel.add(transactionHistory);

        transactionHistory.addActionListener(e -> {
            this.dispose();
            new TransactionHistory();
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(110, 300, 250, 50);
        panel.add(backButton);

        backButton.addActionListener(e -> {
            this.dispose();
            new ViewProfile();
        });

    add(title);
    add(panel);
    }
    public static void main(String[] args) {
        new ViewHistory();
    }
}
    

