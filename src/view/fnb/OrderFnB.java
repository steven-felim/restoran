package view.fnb;

import controller.AuthenticationHelper;
import controller.CartController;
import controller.FnBController;
import model.classes.Cart;
import model.classes.FoodAndBeverage;
import view.employee.cashier.CashierMenu;
import view.member.MemberMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class OrderFnB extends JFrame {
    private String origin;

    public OrderFnB(String origin) {
        this.origin = origin;
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        FnBController fnbc = new FnBController();
        CartController cc = new CartController();

        this.setTitle("Order FnB");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(null);
        topPanel.setPreferredSize(new Dimension(600, 75));

        JButton backButton = new JButton("Back to Main Menu");
        backButton.setBounds(25, 10, 150, 30);

        backButton.addActionListener(e -> {
            if ("Member".equalsIgnoreCase(origin)) {
                this.dispose();
                new MemberMenu();
            } else if ("Cashier".equalsIgnoreCase(origin)) {
                this.dispose();
                new CashierMenu();
            }
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

        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setLayout(null);
        menuPanel.setPreferredSize(new Dimension(560, menuItems.size() * 40));

        List<FoodAndBeverage> orderedItems = new ArrayList<>();
        List<Integer> quantityList = new ArrayList<>();

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

            JButton addFavorit = new JButton("Tambahkan ke Favorit");
            addFavorit.setVisible(true);
            addFavorit.setBounds(252, 5, 190, 30);
            itemPanel.add(addFavorit);

            JButton deleteFavorit = new JButton("Hapus dari favorit");
            deleteFavorit.setVisible(false);
            deleteFavorit.setBounds(252, 5, 190, 30);
            itemPanel.add(deleteFavorit);

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

            if ("Cashier".equalsIgnoreCase(origin)) {
                addFavorit.setVisible(false);
            }

            addFavorit.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Berhasil ditambahkan ke favorit!");
                deleteFavorit.setVisible(true);
                addFavorit.setVisible(false);
            });

            deleteFavorit.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Berhasil ditambahkan ke favorit!");
                addFavorit.setVisible(true);
                deleteFavorit.setVisible(false);
            });

            addButton.addActionListener(e -> {
                quantityField.setVisible(true);
                removeButton.setVisible(true);
                addButton.setVisible(false);
                addFavorit.setVisible(false);
                deleteFavorit.setVisible(false);
            });

            removeButton.addActionListener(e -> {
                quantityField.setVisible(false);
                removeButton.setVisible(false);
                addButton.setVisible(true);
                if ("Member".equalsIgnoreCase(origin)) {
                    addFavorit.setVisible(true);
                }
                deleteFavorit.setVisible(false);

                orderedItems.remove(item);
                quantityList.remove(Integer.parseInt(quantityField.getText()));
            });

            quantityField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    if (keyCode >= KeyEvent.VK_0 && keyCode <= KeyEvent.VK_9) {
                        try {
                            int quantity = Integer.parseInt(quantityField.getText());
                            if (quantity > 0) {
                                int index = orderedItems.indexOf(item);

                                if (index != -1) {
                                    quantityList.set(index, quantity);
                                } else {
                                    orderedItems.add(item);
                                    quantityList.add(quantity);
                                }
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Invalid input.");
                        }
                    }
                }
            });
            menuPanel.add(itemPanel);
        }

        JScrollPane scrollPane = new JScrollPane(menuPanel);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton buyButton = new JButton("Checkout");
        buyButton.addActionListener(e -> {
            if (!"Member".equalsIgnoreCase(origin)) {
                String name = JOptionPane.showInputDialog("Input nama pembeli: ");
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Silakan input nama terlebih dahulu", "Input nama", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            // if (nama pembeli ada di tabel guest) {
            //        langsung input ke cart & transaksi
            //    } else {
            //        input dulu ke tabel guest, karena baru pertama beli
            //        baru input ke cart & transaksi
            //    }
            JOptionPane.showMessageDialog(this, "Pemesanan berhasil!");
            new ConfirmFnBOrder(origin);
            this.dispose();
        });

        bottomPanel.add(buyButton);


        if (!"Cashier".equalsIgnoreCase(origin)) {
            JButton addToCartButton = new JButton("Add to Cart");
            addToCartButton.addActionListener(e -> {
                Cart cart = cc.findOrCreateCartForMember(AuthenticationHelper.getInstance().getRoleId());
                for (int i = 0; i < orderedItems.size(); i++) {
                    cc.addItemToCart(cart.getCart_Id(), orderedItems.get(i).getId(), quantityList.get(i));
                }
            });
            bottomPanel.add(addToCartButton);
        }
        this.add(bottomPanel, BorderLayout.SOUTH);
    }
}