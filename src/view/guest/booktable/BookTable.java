package view.guest.booktable;

import view.guest.GuestMenu;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdatepicker.impl.DateComponentFormatter;

import javax.swing.*;
import view.guest.GuestMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class BookTable extends JFrame {

    private JComboBox<String> roomComboBox;
    private JComboBox<String> tableComboBox;
    private JDatePickerImpl datePicker; 
    private JButton confirmButton;
    private JButton backButton;

    private List<String> vipTables = Arrays.asList("VIP1", "VIP2", "VIP3");
    private List<String> indoorTables = Arrays.asList("Indoor1", "Indoor2", "Indoor3");
    private List<String> outdoorTables = Arrays.asList("Outdoor1", "Outdoor2", "Outdoor3");

    public BookTable() {
        setTitle("Book Table");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Welcome, Guest!");
        title.setBounds(330, 40, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        add(title);

        // Main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Room selection
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Select Room:"), gbc);

        roomComboBox = new JComboBox<>(new String[]{"VIP Room", "Indoor Room", "Outdoor Room"});
        roomComboBox.addActionListener(e -> updateTableComboBox());
        gbc.gridx = 1;
        mainPanel.add(roomComboBox, gbc);

        // Table selection
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Select Table:"), gbc);

        tableComboBox = new JComboBox<>();
        gbc.gridx = 1;
        mainPanel.add(tableComboBox, gbc);

        // Date selection (using JDatePickerImpl)
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Select Date:"), gbc);

        // Initialize UtilDateModel for the date picker
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        // Create JDatePanelImpl
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        // Initialize JDatePickerImpl
        datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        
        gbc.gridx = 1;
        mainPanel.add(datePicker, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        confirmButton = new JButton("Confirm");
        backButton = new JButton("Back");

        buttonPanel.add(confirmButton);
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleConfirmation();
            }
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

        if ("VIP Room".equals(selectedRoom)) {
            vipTables.forEach(tableComboBox::addItem);
        } else if ("Indoor Room".equals(selectedRoom)) {
            indoorTables.forEach(tableComboBox::addItem);
        } else if ("Outdoor Room".equals(selectedRoom)) {
            outdoorTables.forEach(tableComboBox::addItem);
        }
    }

    private void handleConfirmation() {
        String room = (String) roomComboBox.getSelectedItem();
        String table = (String) tableComboBox.getSelectedItem();
        String date = datePicker.getModel().getValue() != null ? new SimpleDateFormat("yyyy-MM-dd").format(datePicker.getModel().getValue()) : "Not selected";

        JOptionPane.showMessageDialog(this, "Table successfully booked!\n" +
                "Details:\nRoom: " + room + "\nTable: " + table + "\nDate: " + date);
        clearSelections();
    }

    private void clearSelections() {
        roomComboBox.setSelectedIndex(0);
        tableComboBox.setSelectedIndex(0);
        datePicker.getModel().setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookTable bookTable = new BookTable();
            bookTable.setVisible(true);
        });
    }
}
