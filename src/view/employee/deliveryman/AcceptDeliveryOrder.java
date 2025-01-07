package view.employee.deliveryman;

import controller.AuthenticationController;
import controller.DeliveryController;
import model.classes.Delivery;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AcceptDeliveryOrder extends JFrame {
    private DefaultTableModel model;
    private DeliveryController dc;

    public AcceptDeliveryOrder() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            this.setVisible(true);
        }
    }

    private void initComponents() {
        model = new DefaultTableModel();
        dc = new DeliveryController();

        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Delivery Order");

        JLabel title = new JLabel("Delivery Order");
        title.setBounds(490, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(100, 80, 1080, 600);

        JButton back = new JButton("Back to Main Menu");
        back.setBounds(0, 0, 160, 30);
        panel.add(back);

        back.addActionListener(e ->  {
            this.dispose();
            new DeliverymanMenu();
        });

        JLabel id = new JLabel("Insert Delivery ID");
        id.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        id.setBounds(200, 0, 220, 30);
        panel.add(id);

        JTextField idField = new JTextField(20);
        idField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        idField.setBounds(410, 0, 220, 30);
        panel.add(idField);

        JButton submit = new JButton("Accept");
        submit.setBounds(660, 0, 220, 30);
        panel.add(submit);

        submit.addActionListener(e -> {
            try {
                System.out.println(Integer.parseInt(idField.getText()));
//            controller, update status di tabel transaksi dari PENDING ke SUCCESS
//            this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Input Must Be Number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JTable table = new JTable(model);
        model.addColumn("Delivery ID");
        model.addColumn("Delivery Status");
        model.addColumn("Address");
        model.addColumn("Transaction ID");
        model.addColumn("Deliveryman ID");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 60, 1080, 600);

        panel.add(scrollPane);

        this.setLayout(null);
        this.add(title);
        this.add(panel);

        loadDataToView();
    }

    private void loadDataToView() {
        List<Delivery> deliveryList = dc.getAllDelivery();

        model.setRowCount(0);

        for (Delivery d : deliveryList) {
            Object[] rowData = { d.getDelivery_id(), d.getDeliveryStatus(), d.getAddress(), d.getTransaction_id(), d.getDeliveryman_id() };
            model.addRow(rowData);
        }
    }
}