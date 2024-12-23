package view.admin;

import controller.AuthenticationController;
import view.admin.employee.EditEmployeeMenu;
import view.admin.employee.ViewDeliveryMan;
import view.admin.fnb.AddDiscount;
import view.admin.fnb.AddFnBMenu;
import view.admin.fnb.DeleteFnBMenu;
import view.admin.fnb.EditFnBMenu;
import view.admin.table.ApproveReschedule;
import view.admin.table.ViewTableOrder;
import view.admin.transaction.ViewSalesReport;
import view.admin.transaction.ViewUserTransaction;
import view.admin.voucher.AddVoucher;
import view.guest.Login;

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
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Admin Menu");

        JLabel title = new JLabel("Welcome back, Admin");
        title.setBounds(490, 50, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 60, 1080, 600);

        JButton approveReschedule = new JButton("Approve Table Reschedule");
        approveReschedule.setBounds(180, 100, 440, 40);
        panel.add(approveReschedule);

        approveReschedule.addActionListener(e -> {
            this.dispose();
            new ApproveReschedule();
        });

        JButton viewTableOrder = new JButton("View Table Order");
        viewTableOrder.setBounds(180, 150, 440, 40);
        panel.add(viewTableOrder);

        viewTableOrder.addActionListener(e -> {
            this.dispose();
            new ViewTableOrder();
        });

        JButton addMenu = new JButton("Add F&B Menu");
        addMenu.setBounds(180, 200, 440, 40);
        panel.add(addMenu);

        addMenu.addActionListener(e -> {
            this.dispose();
            new AddFnBMenu();
        });

        JButton editMenu = new JButton("Edit F&B Menu");
        editMenu.setBounds(180, 250, 440, 40);
        panel.add(editMenu);

        editMenu.addActionListener(e -> {
            this.dispose();
            new EditFnBMenu();
        });

        JButton deleteMenu = new JButton("Delete F&B Menu");
        deleteMenu.setBounds(180, 300, 440, 40);
        panel.add(deleteMenu);

        deleteMenu.addActionListener(e -> {
            this.dispose();
            new DeleteFnBMenu();
        });

        JButton viewTransaction = new JButton("View User's Transaction");
        viewTransaction.setBounds(180, 350, 440, 40);
        panel.add(viewTransaction);

        viewTransaction.addActionListener(e -> {
            this.dispose();
            new ViewUserTransaction();
        });

        JButton viewSales = new JButton("View Sales Report");
        viewSales.setBounds(660, 100, 440, 40);
        panel.add(viewSales);

        viewSales.addActionListener(e -> {
            this.dispose();
            new ViewSalesReport();
        });

        JButton editEmployee = new JButton("Edit Employee");
        editEmployee.setBounds(660, 150, 440, 40);
        panel.add(editEmployee);

        editEmployee.addActionListener(e -> {
            this.dispose();
            new EditEmployeeMenu();
        });

        JButton viewDeliveryMan = new JButton("View Delivery Man");
        viewDeliveryMan.setBounds(660, 200, 440, 40);
        panel.add(viewDeliveryMan);

        viewDeliveryMan.addActionListener(e -> {
            this.dispose();
            new ViewDeliveryMan();
        });

        JButton addVoucher = new JButton("Add Voucher");
        addVoucher.setBounds(660, 250, 440, 40);
        panel.add(addVoucher);

        addVoucher.addActionListener(e -> {
            this.dispose();
            new AddVoucher();
        });

        JButton addDiscount = new JButton("Add Discount");
        addDiscount.setBounds(660, 300, 440, 40);
        panel.add(addDiscount);

        addDiscount.addActionListener(e -> {
            this.dispose();
            new AddDiscount();
        });

        JButton logout = new JButton("Logout");
        logout.setBounds(660, 350, 440, 40);
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
