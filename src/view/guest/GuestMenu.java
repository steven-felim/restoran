package view.guest;

import controller.TableController;
import model.Table;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GuestMenu extends JFrame {

    public GuestMenu(){
        initComponents();
        this.setVisible(true);
    }

    public void initComponents(){
        this.setSize(400, 600);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Guest Menu");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("Guest Menu");
        title.setFont(new Font(Font.TIMES_NEW_ROMAN, Font.BOLD, 30));
        title.setBounds(120, 20, 200, 50);
        this.add(title);

        JButton bookTableButton = new JButton("Book Table");
        bookTableButton.setBounds(50, 100, 300, 40);
        bookTableButton.addActionListener(e -> bookTable());
        this.add(bookTableButton);

        JButton viewMenuButton = new JButton("View Menu");
        viewMenuButton.setBounds(50, 150, 300, 40);
        viewMenuButton.addActionListener(e -> viewMenu());
        this.add(viewMenuButton);
    }

    private void bookTable(){
        List<Table> availableTables = TableController.getAvailableTables();
        if(availableTables.isEmpty()){
            JOptionPane.showMessageDialog(this, "No table available");
            return;
        }

        String[] tableOptions = availableTables.stream().map(table -> 
            "Table " + table.getName() + " Capacity: " + table.getCapacity())
            .toArray(String[]::new);

        String selectedTable = (String) JOptionPane.showInputDialog(this, 
            "Select a table to book:", "Book Table", 
            JOptionPane.QUESTION_MESSAGE, null, tableOptions, tableOptions[0]);

        if(selectedTable != null){
            int tableIndex = java.util.Arrays.asList(tableOptions).indexOf(selectedTable);
            Table table = availableTables.get(tableIndex);

            String date = JOptionPane.showInputDialog(this, "Enter Booking Date (YYYY-MM-DD):");
            String time = JOptionPane.showInputDialog(this, "Enter Booking Time (HH:MM):");

            boolean success = TableController.bookTable(table.getId(), 1, date, time);
            if(success){
                JOptionPane.showMessageDialog(this, "Table booked successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to book table");
            }
        }
    }

    private void viewMenu(){
        JOptionPane.showMessageDialog(this, "Menu functionality to be added.");
    }

    public static void main(String[] args){
        new GuestMenu();
    }
}
