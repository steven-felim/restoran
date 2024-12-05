package view.admin;

import javax.swing.*;
import java.awt.*;

public class AdminMenu extends JFrame {
    public AdminMenu() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Admin Menu");

        JLabel title = new JLabel("Welcome back, Admin");
        title.setBounds(290, 50, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 60, 1080, 600);

        JButton approveReschedule = new JButton("Approve Table Reschedule");
        approveReschedule.setBounds(180, 100, 440, 40);
        panel.add(approveReschedule);

        JButton viewTableOrder = new JButton("View Table Order");
        viewTableOrder.setBounds(180, 150, 440, 40);
        panel.add(viewTableOrder);

        JButton addMenu = new JButton("Add F&B Menu");
        addMenu.setBounds(180, 200, 440, 40);
        panel.add(addMenu);

        JButton editMenu = new JButton("Edit F&B Menu");
        editMenu.setBounds(180, 250, 440, 40);
        panel.add(editMenu);

        JButton deleteMenu = new JButton("Delete F&B Menu");
        deleteMenu.setBounds(180, 300, 440, 40);
        panel.add(deleteMenu);

        JButton viewTransaction = new JButton("View User's Transaction");
        viewTransaction.setBounds(180, 350, 440, 40);
        panel.add(viewTransaction);

        JButton viewSales = new JButton("View Sales Report");
        viewSales.setBounds(660, 100, 440, 40);
        panel.add(viewSales);

        JButton editEmployee = new JButton("Edit Employee");
        editEmployee.setBounds(660, 150, 440, 40);
        panel.add(editEmployee);

        JButton viewDeliveryMan = new JButton("View Delivery Man");
        viewDeliveryMan.setBounds(660, 200, 440, 40);
        panel.add(viewDeliveryMan);

        JButton approveUserDetail = new JButton("Approve User Details");
        approveUserDetail.setBounds(660, 250, 440, 40);
        panel.add(approveUserDetail);

        JButton addVoucher = new JButton("Add Voucher");
        addVoucher.setBounds(660, 300, 440, 40);
        panel.add(addVoucher);

        JButton addDiscount = new JButton("Add Discount");
        addDiscount.setBounds(660, 350, 440, 40);
        panel.add(addDiscount);

        add(title);
        add(panel);
    }

    public static void main(String[] args) {
        new AdminMenu();
    }
}
