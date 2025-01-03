package view.guest.rescheduleGuest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.BookingController;
import model.classes.BookTable;
import view.guest.GuestMenu;

import java.awt.*;
import java.util.List;

public class ViewHistoryGuest extends JFrame {
    private DefaultTableModel model;
    private JTable table;
    private BookingController bookingController;

    public ViewHistoryGuest() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        bookingController = new BookingController();
        model = new DefaultTableModel();

        // Frame settings
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("View and Reschedule Booking History");

        // Title
        JLabel title = new JLabel("Booking History and Reschedule");
        title.setBounds(400, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        // Panel setup
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 80, 1080, 600);

        // Reschedule Button
        JButton rescheduleButton = new JButton("Reschedule");
        rescheduleButton.setBounds(900, 0, 140, 30);
        panel.add(rescheduleButton);

        rescheduleButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String bookID = model.getValueAt(selectedRow, 0).toString();
                this.dispose();
                new Reschedule();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a booking to reschedule.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Back Button
        JButton backButton = new JButton("Back to Main Menu");
        backButton.setBounds(0, 0, 160, 30);
        panel.add(backButton);

        backButton.addActionListener(e -> {
            this.dispose();
            new GuestMenu();
        });

        // Table setup
        table = new JTable(model);
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

        // Load data into the table
        loadDataToView();
    }

    private void loadDataToView() {
        List<BookTable> bookList = bookingController.getGuestBookingHistory();

        model.setRowCount(0);

        for (BookTable t : bookList) {
            Object[] rowData = {
                t.getBookID(),
                t.getTableID(),
                t.getUserID(),
                t.getGuestID(),
                t.getDate(),
                t.getStatus()
            };
            model.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        new ViewHistoryGuest();
    }
}
