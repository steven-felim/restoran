package view.member.history;

import javax.swing.*;

import controller.AuthenticationController;
import view.member.MemberMenu;
import java.awt.*;
    
public class ViewHistory extends JFrame {
    public ViewHistory() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            setVisible(true);
        }
    }

    private void initComponents() {
        this.setSize(400, 360);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("History");

        JLabel title = new JLabel("Your History");
        title.setBounds(100, 22, 300, 51);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        title.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBounds(44, 100, 300, 200);

        JButton bookTableHistoryButton = new JButton("Book Table History");
        bookTableHistoryButton.setBounds(0, 0, 300, 40);
        panel.add(bookTableHistoryButton);
        
        bookTableHistoryButton.addActionListener(e -> {
            this.dispose();
            new BookTableHistory();
        });

        JButton voucherPoinHistory = new JButton("Voucher Poin History");
        voucherPoinHistory.setBounds(0, 50, 300, 40);

        panel.add(voucherPoinHistory);
        voucherPoinHistory.addActionListener(e -> {
            this.dispose();
            new PoinHistory();
        });

        JButton transactionHistory = new JButton("Transaction History");
        transactionHistory.setBounds(0, 100, 300, 40);
        panel.add(transactionHistory);

        transactionHistory.addActionListener(e -> {
            this.dispose();
            new TransactionHistory();
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(0, 150, 300, 40);
        panel.add(backButton);

        backButton.addActionListener(e -> {
            this.dispose();
            new MemberMenu();
        });

    add(title);
    add(panel);
    }
    public static void main(String[] args) {
        new ViewHistory();
    }
}
    

