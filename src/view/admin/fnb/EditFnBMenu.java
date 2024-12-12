package view.admin.fnb;

import controller.FnBController;
import model.classes.FoodAndBeverage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EditFnBMenu extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private FnBController fnbc;
    private FoodAndBeverage temp;

    public EditFnBMenu() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        model = new DefaultTableModel();
        fnbc = new FnBController();

        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Edit F&B Menu");

        JLabel title = new JLabel("Edit F&B Menu");
        title.setBounds(490, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 80, 1080, 600);

        JLabel id = new JLabel("Insert FnB ID");
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
            new EditFnBForm(idField.getText());
        });

        table = new JTable(model);
        model.addColumn("Fnb ID");
        model.addColumn("Name");
        model.addColumn("Stock");
        model.addColumn("Price");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 60, 1080, 600);

        panel.add(scrollPane);

        this.setLayout(null);
        this.add(title);
        this.add(panel);

        loadDataToView();
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

