package view.guest;

import javax.swing.*;

import view.guest.fnb.OrderFnBGuest;
import view.guest.fnb.ViewCart;
import view.guest.login.Register;
import view.guest.table.BookTable;
import view.guest.table.ViewTableGuest;

import java.awt.*;

public class GuestMenu extends JFrame {
    public GuestMenu() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.setSize(400, 410);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Guest Menu");

        JLabel title = new JLabel("Welcome, Guest!");
        title.setBounds(75, 30, 250, 40);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(44, 80, 300, 250);

        JButton bookTableButton = new JButton("Book Table");
        bookTableButton.setBounds(0, 0, 300, 40);
        panel.add(bookTableButton);

        bookTableButton.addActionListener(e ->  {
            this.dispose();
            new BookTable();
        });

        JButton cancelTableButton = new JButton("View Table");
        cancelTableButton.setBounds(0, 50, 300, 40);
        panel.add(cancelTableButton);

        cancelTableButton.addActionListener(e ->  {
            this.dispose();
            new ViewTableGuest();
        });

        JButton orderMenuButton = new JButton("Order F&B Menu");
        orderMenuButton.setBounds(0, 100, 300, 40);
        panel.add(orderMenuButton);

        orderMenuButton.addActionListener(e ->  {
            this.dispose();
            new OrderFnBGuest();
        });

        JButton viewCartButton = new JButton("Cart");
        viewCartButton.setBounds(0, 150, 300, 40);
        panel.add(viewCartButton);

        viewCartButton.addActionListener(e ->  {
            this.dispose();
            new ViewCart();
        });

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(0, 200, 300, 40);
        panel.add(registerButton);

        registerButton.addActionListener(e ->  {
            this.dispose();
            new Register();
        });

        add(title);
        add(panel);
    }
}