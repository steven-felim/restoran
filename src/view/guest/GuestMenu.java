package view.guest;

import javax.swing.*;

import view.bookTable.ViewTable;
import view.fnb.OrderFnB;
import view.fnb.ViewCart;
import view.guest.login.Login;
import view.guest.login.Register;
import view.bookTable.BookTableForm;

import java.awt.*;

public class GuestMenu extends JFrame {
    public GuestMenu() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.setSize(400, 460);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Guest Menu");

        JLabel title = new JLabel("Welcome, Guest!");
        title.setBounds(75, 30, 250, 40);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBounds(44, 80, 300, 300);

        JButton bookTableButton = new JButton("Book Table");
        bookTableButton.setBounds(0, 0, 300, 40);
        panel.add(bookTableButton);

        bookTableButton.addActionListener(e ->  {
            this.dispose();
            new BookTableForm("Guest");
        });

        JButton cancelTableButton = new JButton("View Table");
        cancelTableButton.setBounds(0, 50, 300, 40);
        panel.add(cancelTableButton);

        cancelTableButton.addActionListener(e ->  {
            this.dispose();
            new ViewTable("Guest");
        });

        JButton orderMenuButton = new JButton("Order F&B Menu");
        orderMenuButton.setBounds(0, 100, 300, 40);
        panel.add(orderMenuButton);

        orderMenuButton.addActionListener(e ->  {
            this.dispose();
            new OrderFnB("Guest");
        });

        JButton viewCartButton = new JButton("Cart");
        viewCartButton.setBounds(0, 150, 300, 40);
        panel.add(viewCartButton);

        viewCartButton.addActionListener(e ->  {
            this.dispose();
            new ViewCart("Guest");
        });

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(0, 200, 300, 40);
        panel.add(registerButton);

        registerButton.addActionListener(e ->  {
            this.dispose();
            new Register();
        });

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(0, 250, 300, 40);
        panel.add(loginButton);

        loginButton.addActionListener(e ->  {
            this.dispose();
            new Login();
        });

        add(title);
        add(panel);
    }
}