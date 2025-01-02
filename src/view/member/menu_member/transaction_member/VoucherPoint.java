package view.member.menu_member.transaction_member;

import javax.swing.*;

import model.classes.Transaction;
import model.classes.Voucher;
import model.classes.Wallet;
import view.member.MemberMenu;
import view.member.menu_member.profile.EditProfile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Member;
import java.util.ArrayList;

public class VoucherPoint extends JFrame {
    private JButton btnRedeem;
    private JButton btnCancel;
    private JComboBox<String> voucherComboBox;
    private Member member;

    public VoucherPoint() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("Penukaran Poin");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Membuat panel dan komponen GUI
        JPanel panel = new JPanel();
        add(panel);
        
        panel.setLayout(null);
        
        JLabel label = new JLabel("Pilih Voucher untuk ditukar:");
        label.setBounds(10, 20, 200, 25);
        panel.add(label);
        
        voucherComboBox = new JComboBox<>();
        voucherComboBox.setBounds(10, 50, 200, 25);
        panel.add(voucherComboBox);
        
        //data dari database
        // loadVouchers();
        
        btnRedeem = new JButton("Tukar Voucher");
        btnRedeem.setBounds(10, 100, 150, 25);
        panel.add(btnRedeem);
        
        btnCancel = new JButton("Batal");
        btnCancel.setBounds(200, 100, 100, 25);
        panel.add(btnCancel);
        
        btnRedeem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redeemVoucher();
            }
        });
        
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelRedemption();
            }
        });
    }

    // Redeem voucher yang dipilih
    private void redeemVoucher() {
        int selectedIndex = voucherComboBox.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Pilih voucher terlebih dahulu.");
            return;
        }

    }

    // Batalkan penukaran dan kembali ke menu utama
    private void cancelRedemption() {
        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin membatalkan?", 
        "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            this.dispose(); 
            new MemberMenu();
            System.out.println("Pembatalan berhasil.");
        }
    }


    public static void main(String[] args) {
        new VoucherPoint();
    }
}