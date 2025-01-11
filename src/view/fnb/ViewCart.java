package view.fnb;

import controller.AuthenticationHelper;
import controller.CartController;
import model.classes.Cart;
import view.member.MemberMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class ViewCart extends JFrame {
    private String origin;
    private CartController cc;

    public ViewCart(String origin) {
        this.origin = origin;
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        cc = new CartController();

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

        List<Cart> menuItems = cc.getAllMemberCart(AuthenticationHelper.getInstance().getRoleId());

        JLabel totalLabel = new JLabel("Total Price:    Rp" + cc.getTotalCart());
        for (Cart item : menuItems) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, 5, 5, 5);

            JLabel itemNameLabel = new JLabel(item.getFnb().getName() + " - Rp " + item.getFnb().getPrice());
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            itemPanel.add(itemNameLabel, gbc);

            JPanel quantityPanel = new JPanel();
            quantityPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JTextField quantityField = new JTextField(String.valueOf(item.getQuantity()), 5);
            quantityPanel.add(quantityField);

            quantityField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    if (keyCode >= KeyEvent.VK_0 && keyCode <= KeyEvent.VK_9) {
                        try {
                            int quantity = Integer.parseInt(quantityField.getText());
                            if (quantity > 0) {
                                cc.editCartQuantity(item.getCart_Id(), item.getFnb().getId(), quantity);
                                totalLabel.setText("Total Price:    Rp" + cc.getTotalCart());
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Invalid input.");
                        }
                    }
                }
            });

            JButton removeButton = new JButton("Delete");
            quantityPanel.add(removeButton);

            gbc.gridx = 2;
            gbc.weightx = 0.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            itemPanel.add(quantityPanel, gbc);

            removeButton.addActionListener(e -> {
                JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus item ini?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
                cc.deleteCartItems(item.getCart_Id(), item.getFnb().getId());
            });

            mainPanel.add(itemPanel);
        }
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
