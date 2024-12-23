package view.member.menu_member;

import controller.AuthenticationController;
import view.member.MemberMenu;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import org.jdatepicker.impl.DateComponentFormatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class BookTableForm extends JFrame {

    private JComboBox<String> roomComboBox;
    private JComboBox<String> tableComboBox;
    private JDatePickerImpl datePicker;
    private JButton confirmButton;
    private JButton cancelButton;
    private JButton backButton;

    private List<String> vipTables = Arrays.asList("VIP1", "VIP2", "VIP3");
    private List<String> indoorTables = Arrays.asList("Indoor1", "Indoor2", "Indoor3");
    private List<String> outdoorTables = Arrays.asList("Outdoor1", "Outdoor2", "Outdoor3");

    public BookTableForm() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            this.setVisible(true);
        }
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

        // Main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Select Room:"), gbc);

        roomComboBox = new JComboBox<>(new String[]{"VIP Room", "Indoor Room", "Outdoor Room"});
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
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        gbc.gridx = 1;
        mainPanel.add(datePicker, gbc);

        JPanel buttonPanel = new JPanel();
        confirmButton = new JButton("Confirm");
        backButton = new JButton("Back");

        buttonPanel.add(confirmButton);
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);

        confirmButton.addActionListener(e -> handleConfirmation());
        backButton.addActionListener(e -> {
            this.dispose();
            new MemberMenu();
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
        tableComboBox.removeAllItems();
        datePicker.getModel().setSelected(false);
    }

    public static void main(String[] args) {
        new BookTableForm();
    }
}
