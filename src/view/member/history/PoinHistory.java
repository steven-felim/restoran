package view.member.history;

import javax.swing.*;
import java.awt.*;

import model.classes.Transaction;
import view.member.MemberMenu;
import view.profile.ViewProfile;

import java.util.List;

public class PoinHistory extends JFrame {

    private JTextArea historyTextArea;
    private List<Transaction> transactionHistory;

    public PoinHistory() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("History Penukaran Poin");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("History Penukaran Poin", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        historyTextArea = new JTextArea();
        historyTextArea.setEditable(false); 
        panel.add(new JScrollPane(historyTextArea), BorderLayout.CENTER);

        // loadHistory();

        // private void loadHistory() {
        //     StringBuilder historyContent = new StringBuilder();
        //     SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
        //     if (transactionHistory.isEmpty()) {
        //         historyContent.append("Tidak ada transaksi penukaran poin.");
        //     } else {
        //         for (Transaction transaction : transactionHistory) {
        //             // Format each transaction to display
        //             historyContent.append("Voucher ID: ").append(transaction.getVoucherId())
        //                            .append("\nTanggal Pembelian: ").append(dateFormat.format(transaction.getDatePurchase()))
        //                            .append("\nTotal Poin yang Digunakan: ").append(transaction.getTotal())
        //                            .append("\nStatus: ").append(transaction.getStatus())
        //                            .append("\n-----------------------------\n");
        //         }
        //     }
        //     historyTextArea.setText(historyContent.toString());
        // }

        JPanel panelButton = new JPanel();
        panelButton.setLayout(null);
        panelButton.setBounds(0, 30, 500, 500);

        JButton backButton = new JButton("Back Home");
        backButton.setBounds(10, 320, 100, 30);
        backButton.addActionListener(e -> {
            this.dispose();
            new MemberMenu();
        });
        panelButton.add(backButton);

        JButton profilButton = new JButton("View Profile");
        profilButton.setBounds(350, 320, 120, 30);
        profilButton.addActionListener(e -> {
            this.dispose();
            new ViewProfile();
        });
        panelButton.add(profilButton);

        add(panel);
        add(panelButton);
    }


    public static void main(String[] args) {
        new PoinHistory();
    }
}

