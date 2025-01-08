package view.guest.fnb;

import controller.FnBController;
import model.classes.FoodAndBeverage;
import view.guest.GuestMenu;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OrderFnB extends JFrame {
    public OrderFnB() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        FnBController fnbc = new FnBController();

        this.setTitle("Order FnB");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setPreferredSize(new Dimension(600, 75));

        JButton backButton = new JButton("Back to Main Menu");
        backButton.setBounds(25, 10, 150, 30);

        backButton.addActionListener(e -> {
            this.dispose();
            new GuestMenu();
        });

        JLabel title = new JLabel("Order Menu");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        title.setBounds(200, 10, 300, 30);

        topPanel.add(backButton);
        topPanel.add(title);

        this.add(topPanel, BorderLayout.NORTH);

        List<FoodAndBeverage> menuItems = fnbc.getAllFnb();

        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setLayout(null);
        menuPanel.setPreferredSize(new Dimension(560, menuItems.size() * 40));

        for (int i = 0; i < menuItems.size(); i++) {
            FoodAndBeverage item = menuItems.get(i);

            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(null);
            itemPanel.setBounds(0, i * 40, 560, 40);

            JLabel itemNameLabel = new JLabel(item.getName());
            itemNameLabel.setBounds(0, 0, 200, 40);
            itemPanel.add(itemNameLabel);

            JLabel itemPriceLabel = new JLabel("Rp" + item.getPrice());
            itemPriceLabel.setBounds(200, 0, 50, 40);
            itemPanel.add(itemPriceLabel);

            JButton addButton = new JButton("Keranjang");
            addButton.setBounds(455, 5, 95, 30);
            itemPanel.add(addButton);

            JPanel quantityPanel = new JPanel();
            quantityPanel.setBounds(250, 0, 380, 40);

            JTextField quantityField = new JTextField(5);
            quantityField.setVisible(false);
            quantityField.setBounds(0, 0 , 180, 40);
            quantityPanel.add(quantityField);

            JButton removeButton = new JButton("Hapus");
            removeButton.setVisible(false);
            removeButton.setBounds(200, 0, 160, 40);
            quantityPanel.add(removeButton);

            itemPanel.add(quantityPanel);

            addButton.addActionListener(e -> {
                quantityField.setVisible(true);
                removeButton.setVisible(true);
                addButton.setVisible(false);
            });

            removeButton.addActionListener(e -> {
                quantityField.setVisible(false);
                removeButton.setVisible(false);
                addButton.setVisible(true);
            });

            menuPanel.add(itemPanel);
        }

        JScrollPane scrollPane = new JScrollPane(menuPanel);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton buyButton = new JButton("Checkout");
        buyButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Input nama pembeli: ");
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Silakan input nama terlebih dahulu", "Input nama", JOptionPane.ERROR_MESSAGE);
                return;
            }
                        // if (nama pembeli ada di tabel guest) {
            //        langsung input ke cart & transaksi
            //    } else {
            //        input dulu ke tabel guest, karena baru pertama beli
            //        baru input ke cart & transaksi
            //    }
            JOptionPane.showMessageDialog(this, "Pemesanan berhasil!");
            new ConfirmFnBOrder();
            this.dispose();
        });

        bottomPanel.add(buyButton);
        JButton cancelButton = new JButton("Add to Cart");
        cancelButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Pemesanan dimasukkan ke keranjang.");
            // input ke cart
        });
        bottomPanel.add(cancelButton);

        this.add(bottomPanel, BorderLayout.SOUTH);
    }
}