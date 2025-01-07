package view.member.transaction_member;

import javax.swing.*;

import controller.AuthenticationController;
import controller.VoucherController;
import model.classes.Voucher;
import view.member.MemberMenu;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class VoucherPoint extends JFrame {
    private VoucherController vc;

    public VoucherPoint() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            setVisible(true);
        }
    }

    private void initComponents() {
        vc = new VoucherController();

        setTitle("Exchange Point");
        setSize(600, 400);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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

        JLabel title = new JLabel("Exchange Point");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        title.setBounds(200, 10, 300, 30);

        topPanel.add(backButton);
        topPanel.add(title);

        this.add(topPanel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        List<Voucher> vouchers = vc.getAllVoucher();

        for (Voucher voucher : vouchers) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, 5, 5, 5);

            JLabel itemNameLabel = new JLabel(voucher.getVoucherName() + " - " + voucher.getPoint() + " points");
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            itemPanel.add(itemNameLabel, gbc);

            JButton exchangeButton = new JButton("Tukar voucher");
            gbc.gridx = 1;
            gbc.weightx = 0.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            itemPanel.add(exchangeButton, gbc);

            exchangeButton.addActionListener(e -> {
                JOptionPane.showConfirmDialog(null, "Apakah Anda yakin mau menukar point Anda?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
                // if ok
                //    tukar point
            });
            mainPanel.add(itemPanel);
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new VoucherPoint();
    }
}