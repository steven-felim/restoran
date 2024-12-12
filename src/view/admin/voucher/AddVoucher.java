package view.admin.voucher;

import view.admin.AdminMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddVoucher extends JFrame {
    public AddVoucher() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add Voucher");

        JLabel title = new JLabel("Add New Voucher");
        title.setBounds(490, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 60, 1080, 600);

        JLabel voucherName = new JLabel("Voucher Name");
        voucherName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        voucherName.setBounds(200, 110, 220, 30);
        panel.add(voucherName);

        JTextField voucherNameField = new JTextField(20);
        voucherNameField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        voucherNameField.setBounds(510, 110, 220, 30);
        panel.add(voucherNameField);

        JLabel voucherDisc = new JLabel("Voucher Discount");
        voucherDisc.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        voucherDisc.setBounds(200, 160, 220, 30);
        panel.add(voucherDisc);

        JTextField voucherDiscField = new JTextField(20);
        voucherDiscField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        voucherDiscField.setBounds(510, 160, 220, 30);
        panel.add(voucherDiscField);

        JButton submit = new JButton("Add Voucher");
        submit.setBounds(440, 250, 440, 40);
        panel.add(submit);

        submit.addActionListener(e ->  {
            // Sambungin ke DB, ada controller
        });

        JButton back = new JButton("Back to Main Menu");
        back.setBounds(440, 300, 440, 40);
        panel.add(back);

        back.addActionListener(e ->  {
            this.dispose();
            new AdminMenu();
        });

        this.add(title);
        this.add(panel);
    }
}
