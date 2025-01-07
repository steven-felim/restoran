package view.member.history;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TransactionHistory extends JFrame {
    private JTable historyTable;
    private DefaultTableModel tableModel;

    public TransactionHistory() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("Transaction History");
        setSize(800, 400);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create panel for the title
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Transaction History");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        String[] columnNames = {"Transaction ID", "Date", "Items", "Total", "Delivery Address"};
        tableModel = new DefaultTableModel(columnNames, 0);
        historyTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(historyTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create bottom panel with back button
        JPanel bottomPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            this.dispose();
            new ViewHistory();
        });
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new TransactionHistory();
    }
}

