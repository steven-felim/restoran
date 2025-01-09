package view.admin.table;

import view.admin.AdminMenu;

import javax.swing.*;
import java.awt.*;

public class TableMenu extends JFrame {
    public TableMenu() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.setSize(400, 280);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Table Menu");

        JLabel title = new JLabel("Table Menu");
        title.setBounds(90, 30, 350, 40);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBounds(44, 80, 300, 200);

        JButton approveReschedule = new JButton("View Table Order");
        approveReschedule.setBounds(0, 0, 300, 40);
        panel.add(approveReschedule);

        approveReschedule.addActionListener(e -> {
            this.dispose();
            new ViewTableOrder();
        });

        JButton addMenu = new JButton("Approve Table Reschedule");
        addMenu.setBounds(0, 50, 300, 40);
        panel.add(addMenu);

        addMenu.addActionListener(e -> {
            this.dispose();
            new ApproveReschedule();
        });

        JButton back = new JButton("Back");
        back.setBounds(0, 100, 300, 40);
        panel.add(back);

        back.addActionListener(e -> {
            this.dispose();
            new AdminMenu();
        });

        add(title);
        add(panel);
    }
}
