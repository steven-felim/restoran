package view.employee.chef;

import controller.AuthenticationController;
import controller.FnBController;
import model.classes.FoodAndBeverage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewFnBStock extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private FnBController fnbc;

    public ViewFnBStock() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            this.setVisible(true);
        }
    }

    private void initComponents() {
        model = new DefaultTableModel();
        fnbc = new FnBController();

        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("View F&B Stock");

        JLabel title = new JLabel("View F&B Stock");
        title.setBounds(490, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(100, 80, 1080, 600);

        JLabel id = new JLabel("Insert FnB ID");
        id.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        id.setBounds(250, 0, 150, 30);
        panel.add(id);

        JTextField idField = new JTextField(20);
        idField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        idField.setBounds(410, 0, 220, 30);
        panel.add(idField);

        JButton submit = new JButton("Edit Stock");
        submit.setBounds(660, 0, 220, 30);
        panel.add(submit);

        submit.addActionListener(e -> {
            try {
                new EditFnBStock(Integer.parseInt(idField.getText()));
                this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input Must Be Number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton back = new JButton("Back to Main Menu");
        back.setBounds(0, 0, 160, 30);
        panel.add(back);

        back.addActionListener(e ->  {
            this.dispose();
            new ChefMenu();
        });

        table = new JTable(model);
        model.addColumn("Fnb ID");
        model.addColumn("Name");
        model.addColumn("Stock");
        model.addColumn("Price");

        loadDataToView();

        table.setPreferredScrollableViewportSize(new Dimension(1080, 450));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 60, 1080, 450);
        panel.add(scrollPane);

        this.add(title);
        this.add(panel);
    }

    private void loadDataToView() {
        List<FoodAndBeverage> fnbList = fnbc.getAllFnb();

        model.setRowCount(0);

        for (FoodAndBeverage fnb : fnbList) {
            Object[] rowData = { fnb.getId(), fnb.getName(), fnb.getStock(), fnb.getPrice() };
            model.addRow(rowData);
        }
    }
}