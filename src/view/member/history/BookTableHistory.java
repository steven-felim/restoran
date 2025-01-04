package view.member.history;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import model.classes.BookTable;
import view.member.MemberMenu;
import view.profile.ViewProfile;

public class BookTableHistory extends JFrame {

    private JTable historyTable;
    private DefaultTableModel tableModel;

    public BookTableHistory() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("Booking History");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Booking History", JLabel.CENTER);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Table setup
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Booking ID");
        tableModel.addColumn("Room");
        tableModel.addColumn("Table");
        tableModel.addColumn("Date");
        tableModel.addColumn("Status");

        historyTable = new JTable(tableModel);
        // loadBookingHistory(bookingHistory);

        JScrollPane scrollPane = new JScrollPane(historyTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back Home");
        backButton.addActionListener(e -> {
            this.dispose();
            new MemberMenu();
        });
        buttonPanel.add(backButton);

        JButton profilButton = new JButton("View Profile");
        profilButton.addActionListener(e -> {
            this.dispose();
            new ViewProfile();
        });
        buttonPanel.add(profilButton);
        
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void loadBookingHistory(List<BookTable> bookingHistory) {
        tableModel.setRowCount(0);
        for (BookTable booking : bookingHistory) {
            tableModel.addRow(new Object[]{
                booking.getBookID(),
                // booking.getRoom(),
                // booking.getTable(),
                booking.getDate(),
                booking.getStatus()
            });
        }
    }

    public static void main(String[] args) {
        new BookTableHistory();
    }
}

