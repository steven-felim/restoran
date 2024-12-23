package view.admin.employee;

import controller.AuthenticationController;
import controller.EmployeeController;
import model.classes.Employee;
import view.admin.AdminMenu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EditEmployeeMenu extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private EmployeeController ec;

    public EditEmployeeMenu() {
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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Edit Employee Menu");

        JLabel title = new JLabel("Edit Employee Menu");
        title.setBounds(490, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 80, 1080, 600);

        JLabel id = new JLabel("Insert Employee ID");
        id.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        id.setBounds(200, 0, 220, 30);
        panel.add(id);

        JTextField idField = new JTextField(20);
        idField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        idField.setBounds(410, 0, 220, 30);
        panel.add(idField);

        JButton submit = new JButton("Edit");
        submit.setBounds(660, 0, 220, 30);
        panel.add(submit);

        submit.addActionListener(e -> {
            this.dispose();
            new EditEmployeeForm(Integer.parseInt(idField.getText()));
        });

        JButton back = new JButton("Back to Main Menu");
        back.setBounds(0, 0, 160, 30);
        panel.add(back);

        back.addActionListener(e ->  {
            this.dispose();
            new AdminMenu();
        });

        table = new JTable(model);
        model.addColumn("Employee ID");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Cellphone");
        model.addColumn("Job desk");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 60, 1080, 600);

        panel.add(scrollPane);

        this.setLayout(null);
        this.add(title);
        this.add(panel);

        loadDataToView();
    }

    private void loadDataToView() {
        List<Employee> empList = ec.getAllEmployee();

        model.setRowCount(0);

        for (Employee emp : empList) {
            Object[] rowData = { emp.getId(), emp.getName(), emp.getEmail(), emp.getCellphone(), emp.getJobdesk() };
            model.addRow(rowData);
        }
    }
}