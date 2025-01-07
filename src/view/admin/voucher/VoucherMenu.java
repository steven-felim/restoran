package view.admin.voucher;

import controller.VoucherController;
import model.classes.Voucher;
import view.admin.AdminMenu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VoucherMenu extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private VoucherController vc;

    public VoucherMenu() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        model = new DefaultTableModel();
        vc = new VoucherController();

        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.WHITE);
        this.setTitle("View Voucher");

        JLabel title = new JLabel("View Voucher");
        title.setBounds(540, 20, 300, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBounds(100, 80, 1080, 600);

        JButton back = new JButton("Back to Main Menu");
        back.setBounds(0, 0, 160, 30);
        panel.add(back);

        back.addActionListener(e ->  {
            this.dispose();
            new AdminMenu();
        });

        JButton addVoucher = new JButton("Add Voucher");
        addVoucher.setBounds(460, 0, 160, 30);
        panel.add(addVoucher);

        addVoucher.addActionListener(e -> {
            this.dispose();
            new AddVoucher();
        });

        table = new JTable(model);
        model.addColumn("Voucher ID");
        model.addColumn("Voucher Name");
        model.addColumn("Discount");
        model.addColumn("Nominal");
        model.addColumn("Point");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 60, 1080, 600);

        panel.add(scrollPane);

        this.setLayout(null);
        this.add(title);
        this.add(panel);

        loadDataToView();
    }

    private void loadDataToView() {
        List<Voucher> voucherList = vc.getAllVoucher();

        model.setRowCount(0);

        for (Voucher v : voucherList) {
            Object[] rowData = { v.getVoucherID(),v.getVoucherName(), v.getDiscount(), v.getNominal(), v.getPoint() };
            model.addRow(rowData);
        }
    }
}