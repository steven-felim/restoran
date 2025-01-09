package view.admin.employee;

import controller.AuthenticationController;
import controller.EmployeeController;
import model.classes.Deliveryman;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewDeliveryMan extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private EmployeeController ec;

    public ViewDeliveryMan() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            this.setVisible(true);
        }
    }

    private void initComponents() {
        model = new DefaultTableModel();
        ec = new EmployeeController();

        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("View Deliveryman");

        JLabel title = new JLabel("View Deliveryman");
        title.setBounds(490, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBounds(100, 80, 1080, 600);

        JButton back = new JButton("Back");
        back.setBounds(0, 0, 160, 30);
        panel.add(back);

        back.addActionListener(e ->  {
            this.dispose();
            new EmployeeMenu();
        });

        table = new JTable(model);
        model.addColumn("Employee ID");
        model.addColumn("Name");
        model.addColumn("Job desk");
        model.addColumn("Status");

        loadDataToView();

        table.setPreferredScrollableViewportSize(new Dimension(1080, 450));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 60, 1080, 450);
        panel.add(scrollPane);

        this.setLayout(null);
        this.add(title);
        this.add(panel);
    }

    private void loadDataToView() {
        List<Deliveryman> empList = ec.getAllDeliveryMan();

        model.setRowCount(0);

        for (Deliveryman emp : empList) {
            Object[] rowData = { emp.getId(), emp.getName(), emp.getJobdesk(), emp.getStatus() };
            model.addRow(rowData);
        }
    }
}