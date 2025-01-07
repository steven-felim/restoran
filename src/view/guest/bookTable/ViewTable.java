package view.guest.bookTable;

import model.classes.Table;
import view.guest.GuestMenu;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewTable extends JFrame {
    private JList<String> tableList; 
    private DefaultListModel<String> tableListModel;
    private JButton cancelButton;
    private JButton backButton;
    private JButton rescheduleButton;
    private List<Table> bookedTables;

    public ViewTable() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() { 
        setTitle("Table Booking");
        setSize(500, 400);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Dummy dulu, nanti tarik dari db
        bookedTables = new ArrayList<>();
        bookedTables.add(new Table("Outdoor1", 1));  
        bookedTables.add(new Table("VIP2", 2)); 
        bookedTables.add(new Table("Regular3", 3)); 

        // Title label
        JLabel titleLabel = new JLabel("Table Booking");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        tableListModel = new DefaultListModel<>();

        for (Table table : bookedTables) {
            tableListModel.addElement("Table ID: " + table.getTableID() + ", Table No : " + table.getTableNo());
        }

        tableList = new JList<>(tableListModel);
        tableList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mainPanel.add(new JScrollPane(tableList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        cancelButton = new JButton("Cancel Table");
        rescheduleButton = new JButton("Reschedule Table");
        backButton = new JButton("Back");

        buttonPanel.add(cancelButton);
        buttonPanel.add(rescheduleButton);
        buttonPanel.add(backButton);

        rescheduleButton.addActionListener(e -> {
            new RescheduleTable();
            this.dispose();
        });

        backButton.addActionListener(e -> {
            this.dispose();
            new GuestMenu();
        });

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
}

