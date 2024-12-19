package view.guest.booktable;

import model.classes.Table;
import view.guest.GuestMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ViewCancelTableGuest extends JFrame {

    private JList<String> tableList; 
    private DefaultListModel<String> tableListModel;
    private JButton cancelButton;
    private JButton backButton;
    private JButton viewTableOrderButton;

    private List<Table> bookedTables; 

    public ViewCancelTableGuest() {
        setTitle("Cancel Table Booking");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        bookedTables = new ArrayList<>();
        // contoh : tableID = 1, tableNo = 101
        bookedTables.add(new Table(1, 1));  
        bookedTables.add(new Table(2, 2)); 
        bookedTables.add(new Table(3, 3)); 

        // Title label
        JLabel titleLabel = new JLabel("Cancel Table Booking");
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
        cancelButton = new JButton("Cancel Booking");
        backButton = new JButton("Guest Menu");
        viewTableOrderButton = new JButton("View Table Orders");

        buttonPanel.add(cancelButton);
        buttonPanel.add(backButton);
        buttonPanel.add(viewTableOrderButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCancelBooking();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBackToGuestMenu();
            }
        });

        viewTableOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleViewTableOrder();
            }
        });
    }

    private void handleCancelBooking() {
        String selectedTableText = tableList.getSelectedValue();
        if (selectedTableText != null) {
            int tableID = Integer.parseInt(selectedTableText.split(":")[1].trim().split(",")[0].trim());

            Table tableToRemove = null;
            for (Table table : bookedTables) {
                if (table.getTableID() == tableID) {
                    tableToRemove = table;
                    break;
                }
            }

            //ngapus list order
            if (tableToRemove != null) {
                bookedTables.remove(tableToRemove); 
                tableListModel.removeElement(selectedTableText);  // ngapus dari JList
                JOptionPane.showMessageDialog(this, "Booking for Table ID: " + tableID + " has been cancelled.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a table to cancel.");
        }
    }

    private void handleBackToGuestMenu() {
        this.dispose();
        new GuestMenu();
    }

    private void handleViewTableOrder() {
        this.dispose();
        new ViewTableOrder();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ViewCancelTableGuest viewCancelGuest = new ViewCancelTableGuest();
                viewCancelGuest.setVisible(true);
            }
        });
    }
}

