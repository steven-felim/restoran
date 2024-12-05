package view.admin;

import controller.OrderController;
import controller.orderController;
import model.Order;

import javax.swing.*;
import java.awt.color.*;
import java.util.List;

public class AdminMenu extends JFrame{
    public AdminMenu(){
        initComponents();
        this.setVisible(true);
    }

    public void initComponents(){
        this.setSize(400, 600);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Admin Menu");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("Admin Menu");
        title.setFont(new Font(Font.TIMES_NEW_ROMAN, Font.Bold, 28));
        title.setBounds(120, 20, 200, 50);
        this.add(title);

        JButton viewOrdersButton = new JButton("view Order");
        viewOrdersButton.setBounds(50, 100, 300, 40);
        viewOrdersButton.addActionListener(e -> viewOrders());
        this.add(viewOrdersButton);
    }

    private void viewOrders(){
        List<Order> orders = OrderController.getOrdersByUser(0);
        StringBuilder sb = new StringBuilder("Orders : \n");

        for (Order order : orders) {
            sb.append("Order ID: ").append(order.getId())
                .append(", Menu ID: ").append(order.getMenuId())
                .append(", Quantity: ").append(order.getQuantity())
                .append(", Status: ").append(order.getStatus()).append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString());
    }

    public static void main(String[] args){
        new AdminMenu();
    }
}