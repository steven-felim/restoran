package view.admin.fnb;

import controller.FnBController;
import model.classes.FoodAndBeverage;
import view.admin.AdminMenu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FnBMenu extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private FnBController fnbc;

    public FnBMenu() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        model = new DefaultTableModel();
        fnbc = new FnBController();

        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("F&B Menu");

        JLabel title = new JLabel("F&B Menu");
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

        JButton add = new JButton("Add");
        add.setBounds(660, 0, 100, 30);
        panel.add(add);

        add.addActionListener(e -> {
            this.dispose();
            new AddFnBMenu();
        });

        JButton edit = new JButton("Edit");
        edit.setBounds(780, 0, 100, 30);
        panel.add(edit);

        edit.addActionListener(e -> {
            this.dispose();
            new EditFnBForm(Integer.parseInt(idField.getText()));
        });

        JButton delete = new JButton("Delete");
        delete.setBounds(900, 0, 100, 30);
        panel.add(delete);

        delete.addActionListener(e -> {
            // controller hapus data
        });

        JButton back = new JButton("Back to Main Menu");
        back.setBounds(0, 0, 160, 30);
        panel.add(back);

        back.addActionListener(e ->  {
            this.dispose();
            new AdminMenu();
        });

        table = new JTable(model);
        model.addColumn("Fnb ID");
        model.addColumn("Name");
        model.addColumn("Stock");
        model.addColumn("Price");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 60, 1080, 900);

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