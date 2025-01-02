package view.guest.table;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.BookingController;

import org.jdatepicker.impl.DateComponentFormatter;

import javax.swing.*;
import view.guest.GuestMenu;
import view.guest.rescheduleGuest.ViewHistoryGuest;

import java.awt.*;
import java.util.Properties;

public class BookTable extends JFrame {
    private JComboBox<String> roomComboBox;
    private JComboBox<String> tableComboBox;

    public BookTable() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("Book Table");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Book Table");
        title.setBounds(330, 40, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        add(title);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Select Room:"), gbc);

        roomComboBox = new JComboBox<>(new String[]{"VIP", "Indoor", "Outdoor"});
        roomComboBox.addActionListener(e -> updateTableComboBox());
        gbc.gridx = 1;
        mainPanel.add(roomComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Select Table:"), gbc);

        tableComboBox = new JComboBox<>();
        gbc.gridx = 1;
        mainPanel.add(tableComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Select Date:"), gbc);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

        gbc.gridx = 1;
        mainPanel.add(datePicker, gbc);

        JPanel buttonPanel = new JPanel();
        JButton confirmButton = new JButton("Confirm");
        JButton backButton = new JButton("Back");

        buttonPanel.add(confirmButton);
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);

        confirmButton.addActionListener(e -> {
        // // Get selected data
        // String selectedRoom = (String) roomComboBox.getSelectedItem();
        // String selectedTable = (String) tableComboBox.getSelectedItem();
        // String selectedDate = datePicker.getJFormattedTextField().getText(); 

        // // Save booking data
        // BookingController bookingController = new BookingController();
        // bookingController.saveBooking(new BookTableData(selectedRoom, selectedTable, selectedDate));

        // // Transition to ViewHistoryGuest
        // this.dispose();
        // new ViewHistoryGuest();
    });


        backButton.addActionListener(e -> {
            this.dispose();
            new GuestMenu();
        });

        updateTableComboBox();
    }

    private void updateTableComboBox() {
        String selectedRoom = (String) roomComboBox.getSelectedItem();
        tableComboBox.removeAllItems();

        if (selectedRoom.equals("VIP")) {
            for (int i = 1; i <= 5; i++) {
                tableComboBox.addItem(String.valueOf(i));
            }
        } else if (selectedRoom.equals("Indoor") || selectedRoom.equals("Outdoor")) {
            for (int i = 1; i <= 10; i++) {
                tableComboBox.addItem(String.valueOf(i));
            }
        }
    }

    public static void main(String[] args) {
        new BookTable();
    }
}
