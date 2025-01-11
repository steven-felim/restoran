package view.admin;

import controller.AuthenticationController;
import view.admin.discount.AddDiscount;
import view.admin.employee.EmployeeMenu;
import view.admin.fnb.FnBMenu;
import view.admin.table.TableMenu;
import view.admin.transaction.TransactionMenu;
import view.admin.voucher.VoucherMenu;
import view.guest.login.Login;

import javax.swing.*;
import java.awt.*;

public class AdminMenu extends JFrame {
    public AdminMenu() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            setVisible(true);
        }
    }

    private void initComponents() {
        this.setSize(400, 510);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Admin Menu");

        JLabel title = new JLabel("Welcome back, Admin");
        title.setBounds(30, 30, 350, 40);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBounds(44, 130, 300, 400);

        JButton table = new JButton("Table Menu");
        table.setBounds(0, 0, 300, 40);
        panel.add(table);

        table.addActionListener(e -> {
            this.dispose();
            new TableMenu();
        });

        JButton fnbMenu = new JButton("F&B Menu");
        fnbMenu.setBounds(0, 50, 300, 40);
        panel.add(fnbMenu);

        fnbMenu.addActionListener(e -> {
            this.dispose();
            new FnBMenu();
        });

//        JButton viewTransaction = new JButton("Transaction Menu");
//        viewTransaction.setBounds(0, 100, 300, 40);
//        panel.add(viewTransaction);
//
//        viewTransaction.addActionListener(e -> {
//            this.dispose();
//            new TransactionMenu();
//        });

        JButton editEmployee = new JButton("Employee Menu");
        editEmployee.setBounds(0, 100, 300, 40);
        panel.add(editEmployee);

        editEmployee.addActionListener(e -> {
            this.dispose();
            new EmployeeMenu();
        });

        JButton voucher = new JButton("Voucher");
        voucher.setBounds(0, 150, 300, 40);
        panel.add(voucher);

        voucher.addActionListener(e -> {
            this.dispose();
            new VoucherMenu();
        });

        JButton addDiscount = new JButton("Add Discount");
        addDiscount.setBounds(0, 200, 300, 40);
        panel.add(addDiscount);

        addDiscount.addActionListener(e -> {
            this.dispose();
            new AddDiscount();
        });

        JButton logout = new JButton("Logout");
        logout.setBounds(0, 250, 300, 40);
        panel.add(logout);

        logout.addActionListener(e -> {
            this.dispose();
            new Login();
        });

        add(title);
        add(panel);
    }

    public static void main(String[] args) {
        new AdminMenu();
    }
}