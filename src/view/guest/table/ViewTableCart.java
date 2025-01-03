package view.guest.table;

import model.classes.BookTable;
import view.guest.GuestMenu;
import view.guest.rescheduleGuest.Reschedule;
import view.member.MemberMenu;
import view.member.menu_member.table_member.CancelTableMember;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewTableCart extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private List<BookTable> bookings;

    public ViewTableCart(List<BookTable> bookings) {
        this.bookings = bookings != null ? bookings : new ArrayList<>();
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("View Table Cart");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Your Table Cart", JLabel.CENTER);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        mainPanel.add(title, BorderLayout.NORTH);

        model = new DefaultTableModel();
        model.addColumn("Book ID");
        model.addColumn("Table ID");
        model.addColumn("Date");
        model.addColumn("Status");

        table = new JTable(model);
        loadBookings();

        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton confirmButton = new JButton("Confirm Reservations");
        confirmButton.addActionListener(e -> confirmReservations());
        buttonPanel.add(confirmButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> this.dispose());
        buttonPanel.add(cancelButton);

        cancelButton.addActionListener(e -> {
            this.dispose();
            new ViewCancelTableGuest();
        });

        JButton RescheduleButton = new JButton("Reschedule");
        RescheduleButton.addActionListener(e -> this.dispose());
        buttonPanel.add(RescheduleButton);

        RescheduleButton.addActionListener(e -> {
            this.dispose();
            new Reschedule();
        });

        JButton backButton = new JButton("back");
        backButton.addActionListener(e -> this.dispose());
        buttonPanel.add(backButton);

        backButton.addActionListener(e -> {
            this.dispose();
            new GuestMenu();
        });

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    private void loadBookings() {
        model.setRowCount(0);
        for (BookTable booking : bookings) {
            model.addRow(new Object[]{
                booking.getBookID(),
                booking.getTableID(),
                booking.getDate(),
                booking.getStatus()
            });
        }
    }

    private void confirmReservations() {
        if (bookings.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No reservations to confirm.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Reservations confirmed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            bookings.clear();
            loadBookings();
        }
    }

    public static void main(String[] args) {
        List<BookTable> dummyBookings = new ArrayList<>();
        new ViewTableCart(dummyBookings);
    }
}
