package view.admin.transaction;

import controller.TransactionController;
import model.classes.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewUserTransaction extends JFrame {
    private DefaultTableModel model;
    private TransactionController tc;

    public ViewUserTransaction() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        model = new DefaultTableModel();
        tc = new TransactionController();

        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("User Transaction");

        JLabel title = new JLabel("User Transaction");
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
            new TransactionMenu();
        });

        JLabel id = new JLabel("Insert Member/Guest ID");
        id.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        id.setBounds(180, 0, 220, 30);
        panel.add(id);

        JTextField idField = new JTextField(20);
        idField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        idField.setBounds(410, 0, 220, 30);
        panel.add(idField);

        JButton member = new JButton("Search Member");
        member.setBounds(660, 0, 110, 30);
        panel.add(member);

        member.addActionListener(e -> {
            loadMemberDataToView(Integer.parseInt(idField.getText()));
        });

        JButton guest = new JButton("Search Guest");
        guest.setBounds(790, 0, 110, 30);
        panel.add(guest);

        guest.addActionListener(e -> {
            loadGuestDataToView(Integer.parseInt(idField.getText()));
        });

        JTable table = new JTable(model);
        model.addColumn("Transaction ID");
        model.addColumn("Member/Guest ID");
        model.addColumn("Cart ID");
        model.addColumn("Purchase Date");
        model.addColumn("Status");
        model.addColumn("Total Amount");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 60, 1080, 600);
        panel.add(scrollPane);

        panel.add(id);
        panel.add(member);
        panel.add(guest);
        panel.add(back);

        this.setLayout(null);
        this.add(title);
        this.add(panel);
    }

    private void loadMemberDataToView(int id) {
        List<Transaction> transList = tc.getMemberTransaction(id);

        model.setRowCount(0);

        for (Transaction t : transList) {
            Object[] rowData = { t.getTransactionId(), t.getDatePurchase() };
            model.addRow(rowData);
        }
    }

    private void loadGuestDataToView(int id) {
        List<Transaction> transList = tc.getGuestTransaction(id);

        model.setRowCount(0);

        for (Transaction t : transList) {
            Object[] rowData = { t.getTransactionId(), t.getDatePurchase() };
            model.addRow(rowData);
        }
    }
}