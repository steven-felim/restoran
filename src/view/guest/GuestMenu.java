package view.guest;

import javax.swing.*;
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
        title.setBounds(290, 50, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 60, 1080, 600);

        JButton bookTableButton = new JButton("Book Table");
        bookTableButton.setBounds(180, 100, 440, 40);
        panel.add(bookTableButton);

        JButton rescheduleTableButton = new JButton("Reschedule Table");
        rescheduleTableButton.setBounds(180, 150, 440, 40);
        panel.add(rescheduleTableButton);

        JButton cancelTableButton = new JButton("Cancel Table");
        cancelTableButton.setBounds(180, 200, 440, 40);
        panel.add(cancelTableButton);

        JButton viewTableOrder = new JButton("View Table Order");
        viewTableOrder.setBounds(660, 100, 440, 40);
        panel.add(viewTableOrder);

        JButton orderMenuButton = new JButton("Order F&B Menu");
        orderMenuButton.setBounds(660, 150, 440, 40);
        panel.add(orderMenuButton);

        JButton viewCartButton = new JButton("Cart");
        viewCartButton.setBounds(660, 200, 440, 40);
        panel.add(viewCartButton);

        add(title);
        add(panel);
    }

    public static void main(String[] args) {
        new GuestMenu();
    }
}