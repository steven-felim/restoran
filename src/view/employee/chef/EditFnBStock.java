package view.employee.chef;

import controller.FnBController;
import model.classes.FoodAndBeverage;

import javax.swing.*;
import java.awt.*;

public class EditFnBStock extends JFrame {
    private FoodAndBeverage temp;
    private FnBController fnbc;

    public EditFnBStock(int id) {
        fnbc = new FnBController();
        temp = fnbc.getDataFromDB(id);

        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Edit F&B Stock");

        JLabel title = new JLabel("Edit F&B Stock");
        title.setBounds(490, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 60, 1080, 600);

        JLabel menuName = new JLabel("Menu Name");
        menuName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        menuName.setBounds(200, 110, 220, 30);
        panel.add(menuName);

        JTextField menuNameField = new JTextField(temp.getName(), 20);
        menuNameField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        menuNameField.setEnabled(false);
        menuNameField.setBounds(510, 110, 220, 30);
        panel.add(menuNameField);

        JLabel stock = new JLabel("Menu Stock");
        stock.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        stock.setBounds(200, 160, 220, 30);
        panel.add(stock);

        JTextField stockField = new JTextField(String.valueOf(temp.getStock()), 20);
        stockField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        stockField.setBounds(510, 160, 220, 30);
        panel.add(stockField);

        JLabel price = new JLabel("Menu Price");
        price.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        price.setBounds(200, 210, 220, 30);
        panel.add(price);

        JTextField priceField = new JTextField(String.valueOf(temp.getPrice()), 20);
        priceField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        priceField.setEnabled(false);
        priceField.setBounds(510, 210, 220, 30);
        panel.add(priceField);

        JButton submit = new JButton("Add Stock");
        submit.setBounds(440, 260, 440, 40);
        panel.add(submit);

        submit.addActionListener(e ->  {
            // Sambungin ke DB, ada controller
        });

        JButton back = new JButton("Back to Main Menu");
        back.setBounds(440, 310, 440, 40);
        panel.add(back);

        back.addActionListener(e ->  {
            this.dispose();
            new ChefMenu();
        });

        this.add(title);
        this.add(panel);
    }
}
