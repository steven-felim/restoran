package view.admin.employee;

import controller.AuthenticationController;
import controller.EmployeeController;
import model.classes.Employee;
import model.enums.Jobdesk;

import javax.swing.*;
import java.awt.*;

public class EditEmployeeForm extends JFrame {
    private Employee temp;
    private EmployeeController ec;
    private int id = 0;

    public EditEmployeeForm(int id) {
        ec = new EmployeeController();
        temp = ec.getDataFromDB(id);
        this.id = id;

        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            this.setVisible(true);
        }
    }

    private void initComponents() {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Edit Employee");

        JLabel title = new JLabel("Edit Employee");
        title.setBounds(490, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBounds(100, 60, 1080, 600);

        JLabel empName = new JLabel("Employee Name");
        empName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        empName.setBounds(200, 110, 220, 30);
        panel.add(empName);

        JTextField empNameField = new JTextField(temp.getName(), 20);
        empNameField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        empNameField.setBounds(510, 110, 220, 30);
        panel.add(empNameField);

        JLabel email = new JLabel("Email");
        email.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        email.setBounds(200, 160, 220, 30);
        panel.add(email);

        JTextField emailField = new JTextField(String.valueOf(temp.getEmail()), 20);
        emailField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        emailField.setBounds(510, 160, 220, 30);
        panel.add(emailField);

        JLabel cellPhone = new JLabel("Cellphone");
        cellPhone.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        cellPhone.setBounds(200, 210, 220, 30);
        panel.add(cellPhone);

        JTextField cellPhoneField = new JTextField(String.valueOf(temp.getCellphone()), 20);
        cellPhoneField.setEnabled(false);
        cellPhoneField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        cellPhoneField.setBounds(510, 210, 220, 30);
        panel.add(cellPhoneField);

        JLabel role = new JLabel("Job Desk");
        role.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        role.setBounds(200, 260, 220, 30);
        panel.add(role);

        JRadioButton cashier = new JRadioButton(String.valueOf(Jobdesk.CASHIER));
        cashier.setBounds(510, 260, 100, 30);
        JRadioButton chef = new JRadioButton(String.valueOf(Jobdesk.CHEF));
        chef.setBounds(660, 260, 100, 30);
        JRadioButton waiter = new JRadioButton(String.valueOf(Jobdesk.WAITER));
        waiter.setBounds(810, 260, 100, 30);
        JRadioButton deliveryman = new JRadioButton(String.valueOf(Jobdesk.DELIVERYMAN));
        deliveryman.setBounds(960, 260, 150, 30);

        switch(temp.getJobdesk()) {
            case CASHIER:
                cashier.setSelected(true);
            case CHEF:
                chef.setSelected(true);
            case WAITER:
                waiter.setSelected(true);
            case DELIVERYMAN:
                deliveryman.setSelected(true);
        }

        ButtonGroup job = new ButtonGroup();
        job.add(cashier);
        job.add(chef);
        job.add(waiter);
        job.add(deliveryman);

        panel.add(cashier);
        panel.add(chef);
        panel.add(waiter);
        panel.add(deliveryman);

        JButton submit = new JButton("Edit");
        submit.setBounds(440, 310, 440, 40);
        panel.add(submit);

        submit.addActionListener(e ->  {
            String jobdesk = "";
            JRadioButton[] radio = {cashier, chef, waiter, deliveryman};
            for (JRadioButton button : radio) {
                if (button.isSelected()) {
                    jobdesk = button.getText();
                }
            }
            new EmployeeController().editEmployee(
                    id,
                    empNameField.getText(),
                    emailField.getText(),
                    jobdesk
            );
            JOptionPane.showMessageDialog(null, "Data Berhasil Diedit.", "Sukses!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new EmployeeMenu();
        });

        JButton back = new JButton("Back");
        back.setBounds(440, 360, 440, 40);
        panel.add(back);

        back.addActionListener(e ->  {
            this.dispose();
            new EditEmployeeMenu();
        });

        this.add(title);
        this.add(panel);
    }
}
