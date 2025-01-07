package view.admin.table;

import controller.AuthenticationController;
import controller.BookingController;
import model.classes.BookTable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewTableOrder extends JFrame {
    private DefaultTableModel model;
    private BookingController bc;

    public ViewTableOrder() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            this.setVisible(true);
        }
    }

    private void initComponents() {
        model = new DefaultTableModel();
        bc = new BookingController();

        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Table Order");

        JLabel title = new JLabel("Table Order");
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
            new TableMenu();
        });

        JTable table = new JTable(model);
        model.addColumn("Book ID");
        model.addColumn("Table ID");
        model.addColumn("User ID");
        model.addColumn("Guest ID");
        model.addColumn("Date");
        model.addColumn("Status");

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 60, 1080, 600);

        panel.add(scrollPane);

        this.setLayout(null);
        this.add(title);
        this.add(panel);

        loadDataToView();
    }

    private void loadDataToView() {
        List<BookTable> bookList = bc.getAllBookTable();

        model.setRowCount(0);

        for (BookTable t : bookList) {
            Object[] rowData = { t.getBookID(), t.getTableID(), t.getUserID(), t.getGuestID(), t.getDate(), t.getStatus() };
            model.addRow(rowData);
        }
    }
}