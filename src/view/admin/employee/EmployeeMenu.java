package view.admin.employee;

import view.admin.AdminMenu;

import javax.swing.*;
import java.awt.*;

public class EmployeeMenu extends JFrame {
    public EmployeeMenu() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.setSize(400, 320);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Employee Menu");

        JLabel title = new JLabel("Employee Menu");
        title.setBounds(80, 30, 350, 40);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBounds(44, 80, 300, 200);

        JButton addEmployee = new JButton("Add Employee");
        addEmployee.setBounds(0, 0, 300, 40);
        panel.add(addEmployee);

        addEmployee.addActionListener(e -> {
            this.dispose();
            new AddEmployee();
        });

        JButton editEmployee = new JButton("Edit Employee");
        editEmployee.setBounds(0, 50, 300, 40);
        panel.add(editEmployee);

        editEmployee.addActionListener(e -> {
            this.dispose();
            new EditEmployeeMenu();
        });

        JButton viewDeliveryman = new JButton("View Deliveryman");
        viewDeliveryman.setBounds(0, 100, 300, 40);
        panel.add(viewDeliveryman);

        viewDeliveryman.addActionListener(e -> {
            this.dispose();
            new ViewDeliveryMan();
        });

        JButton back = new JButton("Back");
        back.setBounds(0, 150, 300, 40);
        panel.add(back);

        back.addActionListener(e -> {
            this.dispose();
            new AdminMenu();
        });

        add(title);
        add(panel);
    }
}
