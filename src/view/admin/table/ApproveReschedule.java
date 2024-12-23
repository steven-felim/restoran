package view.admin.table;

import controller.BookingController;
import model.classes.BookTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ApproveReschedule extends JFrame {
    private DefaultTableModel model;
    private BookingController bc;

    public ApproveReschedule() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        model = new DefaultTableModel();
        bc = new BookingController();

        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Approve Table Reschedule");

        JLabel title = new JLabel("Approve Table Reschedule");
        title.setBounds(450, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 80, 1080, 600);

        JLabel id = new JLabel("Insert Book ID");
        id.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        id.setBounds(200, 0, 220, 30);
        panel.add(id);

        JTextField idField = new JTextField(20);
        idField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        idField.setBounds(410, 0, 220, 30);
        panel.add(idField);

        JButton approve = new JButton("Approve");
        approve.setBounds(660, 0, 120, 30);
        panel.add(approve);

        approve.addActionListener(e -> {
            // Controller update status dari pending ke booked
        });

        JButton decline = new JButton("Decline");
        decline.setBounds(800, 0, 120, 30);
        panel.add(decline);

        decline.addActionListener(e -> {
            // Controller kembalikan ke book table asal
        });

        JButton back = new JButton("Back to Main Menu");
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
        List<BookTable> bookList = bc.getAllRescheduledBookTable();

        model.setRowCount(0);

        for (BookTable t : bookList) {
            Object[] rowData = { t.getBookID(), t.getTableID(), t.getUserID(), t.getGuestID(), t.getDate(), t.getStatus() };
            model.addRow(rowData);
        }
    }
}