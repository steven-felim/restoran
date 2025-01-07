package view.fnb;

import controller.FnBController;
import model.classes.FoodAndBeverage;
import view.guest.GuestMenu;
import view.member.MemberMenu;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewCart extends JFrame {
    private String origin;
    private FnBController fnbc;
    // FnBController hanya untuk contoh gambaran program, nanti pakai data fnb di cart

    public ViewCart(String origin) {
        this.origin = origin;
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        fnbc = new FnBController();

        this.setTitle("Cart Summary");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(null);
        topPanel.setPreferredSize(new Dimension(600, 75));

        JButton backButton = new JButton("Back to Main Menu");
        backButton.setBounds(25, 10, 150, 30);

        backButton.addActionListener(e -> {
                this.dispose();
                new MemberMenu();            
        });

        JLabel title = new JLabel("Your FnB Order");
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

            JPanel quantityPanel = new JPanel();
            quantityPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JTextField quantityField = new JTextField(5);
            quantityPanel.add(quantityField);
            // jumlah yg dipesan menyesuaikan cart & otomatis terisi di text field

            JButton removeButton = new JButton("Delete");
            quantityPanel.add(removeButton);

            gbc.gridx = 2;
            gbc.weightx = 0.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            itemPanel.add(quantityPanel, gbc);

            removeButton.addActionListener(e -> {
                // hapus dari cart
            });

            mainPanel.add(itemPanel);
        }
        JLabel totalLabel = new JLabel("Total Price:    Rp"); // tambahkan total harga cart melalui controller
        mainPanel.add(totalLabel);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton buyButton = new JButton("Checkout");
        buyButton.addActionListener(e -> {
            // input pesanan ke db
            JOptionPane.showMessageDialog(this, "Pemesanan berhasil!");
            new ConfirmFnBOrder(origin);
            this.dispose();
        });

        bottomPanel.add(buyButton);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }
}
