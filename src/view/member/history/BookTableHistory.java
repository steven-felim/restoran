package view.member.history;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BookTableHistory extends JFrame {

    private JTable historyTable;
    private DefaultTableModel tableModel;

    public BookTableHistory() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("Booking History");
        setSize(800, 600);
        this.getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("Booking History", JLabel.CENTER);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Table setup
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Booking ID");
        tableModel.addColumn("Room");
        tableModel.addColumn("Table");
        tableModel.addColumn("Date");
        tableModel.addColumn("Status");

        historyTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(historyTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back Home");
        backButton.addActionListener(e -> {
            this.dispose();
            new ViewHistory();
        });
        buttonPanel.add(backButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
}

