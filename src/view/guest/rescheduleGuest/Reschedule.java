package view.guest.rescheduleGuest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.*;
import java.awt.*;
import java.util.Properties;

public class Reschedule {

    private JTable table;
    private DefaultTableModel model;
    private JComboBox<String> roomComboBox;
    private JComboBox<String> tableComboBox;
    private JDatePickerImpl datePicker;
    private JButton rescheduleButton;

    public Reschedule() {
        initComponents();
        this.setVisible(true);
            }
        
            private void setVisible(boolean b) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'setVisible'");
            }
        
            private void initComponents() {
        JFrame frame = new JFrame("Reschedule Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        // Table Section
        model = new DefaultTableModel();
        model.addColumn("Book ID");
        model.addColumn("Table ID");
        model.addColumn("User ID");
        model.addColumn("Guest ID");
        model.addColumn("Date");
        model.addColumn("Status");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 740, 200);
        mainPanel.add(scrollPane);

        // Room Selection
        JLabel roomLabel = new JLabel("Select Room:");
        roomLabel.setBounds(20, 240, 100, 25);
        mainPanel.add(roomLabel);

        roomComboBox = new JComboBox<>(new String[]{"", "VIP", "Indoor", "Outdoor"});
        roomComboBox.setBounds(140, 240, 200, 25);
        mainPanel.add(roomComboBox);

        // Table Selection
        JLabel tableLabel = new JLabel("Select Table:");
        tableLabel.setBounds(20, 280, 100, 25);
        mainPanel.add(tableLabel);

        tableComboBox = new JComboBox<>(new String[]{ "", "1", "2", "3", "4", "5"}); 
        tableComboBox.setBounds(140, 280, 200, 25);
        mainPanel.add(tableComboBox);

        // Date Selection
        JLabel dateLabel = new JLabel("Select Date:");
        dateLabel.setBounds(20, 320, 100, 25);
        mainPanel.add(dateLabel);

        UtilDateModel dateModel = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);
        datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        datePicker.setBounds(140, 320, 200, 25);
        mainPanel.add(datePicker);

        // Reschedule Button
        rescheduleButton = new JButton("Reschedule");
        rescheduleButton.setBounds(140, 360, 200, 30);
        mainPanel.add(rescheduleButton);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public JTable getTable() {
        return table;
    }

    public JComboBox<String> getRoomComboBox() {
        return roomComboBox;
    }

    public JComboBox<String> getTableComboBox() {
        return tableComboBox;
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }

    public JButton getRescheduleButton() {
        return rescheduleButton;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public static void main(String[] args) {
        new Reschedule();
    }
}

