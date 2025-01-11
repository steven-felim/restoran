package view.bookTable;

import controller.BookingController;
import controller.TableController;
import model.classes.BookTable;
import model.classes.Table;
import view.guest.GuestMenu;
import view.member.MemberMenu;
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

        JLabel titleLabel = new JLabel("Table Booking");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BorderLayout());

        tableListModel = new DefaultListModel<>();

        for (BookTable bookTable : new BookingController().getMemberBookTable()) {
            int tableNo = new TableController().getTableNo(bookTable.getTableID());
            tableListModel.addElement("Table ID: " + bookTable.getTableID() + ", Table No : " + tableNo);
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
            new MemberMenu();
        });

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
}

