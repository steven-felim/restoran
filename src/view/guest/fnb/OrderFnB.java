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

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        List<FoodAndBeverage> menuItems = fnbc.getAllFnb();

        for (FoodAndBeverage item : menuItems) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, 5, 5, 5);

            JLabel itemNameLabel = new JLabel(item.getName() + " - Rp " + item.getPrice());
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            itemPanel.add(itemNameLabel, gbc);

            JButton addButton = new JButton("Tambahkan ke Keranjang");
            gbc.gridx = 1;
            gbc.weightx = 0.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            itemPanel.add(addButton, gbc);

            JPanel quantityPanel = new JPanel();
            quantityPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JTextField quantityField = new JTextField(5);
            quantityField.setVisible(false);
            quantityPanel.add(quantityField);

            JButton removeButton = new JButton("Hapus");
            removeButton.setVisible(false);
            quantityPanel.add(removeButton);

            gbc.gridx = 2;
            gbc.weightx = 0.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            itemPanel.add(quantityPanel, gbc);

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

            mainPanel.add(itemPanel);
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
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