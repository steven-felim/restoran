package view.admin.voucher;

import controller.AuthenticationController;

import javax.swing.*;
import java.awt.*;

public class AddVoucher extends JFrame {
    public AddVoucher() {
        initComponents();
        if (!new AuthenticationController().checkUser()) {
            this.dispose();
        } else {
            setVisible(true);
        }
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
        panel.setBackground(Color.WHITE);
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

        JLabel voucherNominal = new JLabel("Voucher Nominal");
        voucherNominal.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        voucherNominal.setBounds(200, 210, 220, 30);
        panel.add(voucherNominal);

        JTextField voucherNominalField = new JTextField(20);
        voucherNominalField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        voucherNominalField.setBounds(510, 210, 220, 30);
        panel.add(voucherNominalField);

        JLabel point = new JLabel("Point");
        point.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        point.setBounds(200, 260, 220, 30);
        panel.add(point);

        JTextField pointField = new JTextField(20);
        pointField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        pointField.setBounds(510, 260, 220, 30);
        panel.add(pointField);

        JButton submit = new JButton("Add Voucher");
        submit.setBounds(440, 350, 440, 40);
        panel.add(submit);

        submit.addActionListener(e ->  {
            // Sambungin ke DB, ada controller
        });

        JButton back = new JButton("Back to Main Menu");
        back.setBounds(440, 400, 440, 40);
        panel.add(back);

        back.addActionListener(e ->  {
            this.dispose();
            new VoucherMenu();
        });

        this.add(title);
        this.add(panel);
    }
}
