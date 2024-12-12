package view.admin.transaction;

import controller.TransactionController;
import model.classes.Transaction;
import view.admin.AdminMenu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewSalesReport extends JFrame {
    private DefaultTableModel model;
    private TransactionController tc;

    public ViewSalesReport() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        model = new DefaultTableModel();
        tc = new TransactionController();

        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Sales Report");

        JLabel title = new JLabel("Sales Report");
        title.setBounds(490, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 80, 1080, 600);

        JButton back = new JButton("Back to Main Menu");
        back.setBounds(0, 0, 160, 30);
        panel.add(back);

        back.addActionListener(e ->  {
            this.dispose();
            new AdminMenu();
        });

        JTable table = new JTable(model);
        model.addColumn("Transaction ID");
        model.addColumn("User ID");
        model.addColumn("Guest ID");
        model.addColumn("Cart ID");
        model.addColumn("Purchase Date");
        model.addColumn("Status");
        model.addColumn("Total Amount");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 60, 1080, 600);

        panel.add(scrollPane);

        this.setLayout(null);
        this.add(title);
        this.add(panel);

        loadDataToView();
    }

    private void loadDataToView() {
        List<Transaction> transList = tc.getAllTransaction();

        model.setRowCount(0);

        for (Transaction t : transList) {
            Object[] rowData = { t.getTransactionId(), t.getDatePurchase() };
            model.addRow(rowData);
        }
    }
}