package view.admin.fnb;

import controller.DiscountController;
import model.classes.Discount;
import view.admin.AdminMenu;

import javax.swing.*;
import java.awt.*;

public class AddDiscount extends JFrame {
    private Discount member, guest;
    private DiscountController dc;

    public AddDiscount() {
        dc = new DiscountController();
        member = dc.getMemberDisc();
        guest = dc.getGuestDisc();

        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add Discount");

        JLabel title = new JLabel("Add Discount");
        title.setBounds(490, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 60, 1080, 600);

        JLabel memberLabel = new JLabel("Member Discount");
        memberLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        memberLabel.setBounds(200, 110, 220, 30);
        panel.add(memberLabel);

        JTextField memberField = new JTextField(String.valueOf(member.getDiscount_percent()), 20);
        memberField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        memberField.setBounds(510, 110, 220, 30);
        panel.add(memberField);

        JLabel guestLabel = new JLabel("Guest Discount");
        guestLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        guestLabel.setBounds(200, 160, 220, 30);
        panel.add(guestLabel);

        JTextField guestField = new JTextField(String.valueOf(guest.getDiscount_percent()), 20);
        guestField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        guestField.setBounds(510, 160, 220, 30);
        panel.add(guestField);

        JButton submit = new JButton("Update Discount");
        submit.setBounds(440, 260, 440, 40);
        panel.add(submit);

        submit.addActionListener(e ->  {
            if (dc.updateMemberDiscount(Double.valueOf(memberField.getText())) && dc.updateGuestDiscount(Double.valueOf(guestField.getText()))) {
                JOptionPane.showMessageDialog(null, "Discount successfully updated!");
            } else {
                JOptionPane.showMessageDialog(null, "Something went wrong!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton back = new JButton("Back to Main Menu");
        back.setBounds(440, 310, 440, 40);
        panel.add(back);

        back.addActionListener(e ->  {
            this.dispose();
            new AdminMenu();
        });

        this.add(title);
        this.add(panel);
    }
}
