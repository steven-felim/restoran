package view.member.history;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PoinHistory extends JFrame {
    private JTable historyTable;
    private DefaultTableModel tableModel;

    public PoinHistory() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("History Penukaran Poin");
        setSize(500, 400);
        this.getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("History Penukaran Poin", JLabel.CENTER);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Table setup
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Date");
        tableModel.addColumn("Voucher Name");
        tableModel.addColumn("Point");

        historyTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(historyTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back Home");
        backButton.addActionListener(e -> {
            this.dispose();
            new ViewHistory();
        });
        buttonPanel.add(backButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel);
    }
}