package view.guest;

import javax.swing.*;

import view.guest.fnb.ViewOrderFAndBGuest;
import view.guest.rescheduleGuest.ViewHistoryGuest;
import view.guest.table.BookTable;
import view.guest.table.ViewCancelTableGuest;

import java.awt.*;

public class GuestMenu extends JFrame {
    public GuestMenu() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Guest Menu");

        JLabel title = new JLabel("Welcome, Guest!");
        title.setBounds(520, 40, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 60, 1080, 600);

        JButton bookTableButton = new JButton("Book Table");
        bookTableButton.setBounds(180, 100, 440, 40);
        panel.add(bookTableButton);

        bookTableButton.addActionListener(e ->  {
            this.dispose();
            new BookTable();
        });

        JButton rescheduleTableButton = new JButton("Reschedule Table");
        rescheduleTableButton.setBounds(180, 150, 440, 40);
        panel.add(rescheduleTableButton);

        
        rescheduleTableButton.addActionListener(e ->  {
            this.dispose();
            new ViewHistoryGuest();
        });

        JButton cancelTableButton = new JButton("Cancel Table");
        cancelTableButton.setBounds(180, 200, 440, 40);
        panel.add(cancelTableButton);

        cancelTableButton.addActionListener(e ->  {
            this.dispose();
            new ViewCancelTableGuest();
        });

        JButton viewTableOrder = new JButton("View Table Order");
        viewTableOrder.setBounds(660, 100, 440, 40);
        panel.add(viewTableOrder);

        viewTableOrder.addActionListener(e ->  {
            this.dispose();
            new ();
        });

        JButton orderMenuButton = new JButton("Order F&B Menu");
        orderMenuButton.setBounds(660, 150, 440, 40);
        panel.add(orderMenuButton);

        orderMenuButton.addActionListener(e ->  {
            this.dispose();
            new ViewOrderFAndBGuest();
        });

        JButton viewCartButton = new JButton("Cart");
        viewCartButton.setBounds(660, 200, 440, 40);
        panel.add(viewCartButton);

        viewCartButton.addActionListener(e ->  {
            this.dispose();
            new ViewCancelTableGuest();
        });

        add(title);
        add(panel);
    }

    public static void main(String[] args) {
        new GuestMenu();
    }
}