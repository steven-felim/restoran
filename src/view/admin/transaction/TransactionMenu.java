package view.admin.transaction;

import view.admin.AdminMenu;

import javax.swing.*;
import java.awt.*;

public class TransactionMenu extends JFrame {
    public TransactionMenu() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.setSize(400, 280);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Transaction Menu");

        JLabel title = new JLabel("Transaction Menu");
        title.setBounds(60, 30, 350, 40);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBounds(44, 80, 300, 200);

        JButton salesReport = new JButton("View Sales Report");
        salesReport.setBounds(0, 0, 300, 40);
        panel.add(salesReport);

        salesReport.addActionListener(e -> {
            this.dispose();
            new ViewSalesReport();
        });

        JButton userTransaction = new JButton("View User's Transaction");
        userTransaction.setBounds(0, 50, 300, 40);
        panel.add(userTransaction);

        userTransaction.addActionListener(e -> {
            this.dispose();
            new ViewUserTransaction();
        });

        JButton back = new JButton("Back");
        back.setBounds(0, 100, 300, 40);
        panel.add(back);

        back.addActionListener(e -> {
            this.dispose();
            new AdminMenu();
        });

        add(title);
        add(panel);
    }
}
