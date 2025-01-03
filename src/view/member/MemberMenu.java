package view.member;

import javax.swing.*;

import controller.AuthenticationController;
import controller.AuthenticationHelper;
import view.guest.table.ViewCancelTableGuest;
import view.member.menu_member.fnb_member.OrderFnBMember;
import view.member.menu_member.fnb_member.ViewCartMember;
import view.member.menu_member.profile.EditProfile;
import view.member.menu_member.profile.ViewProfile;
import view.member.menu_member.table_member.BookTableForm;
import view.member.menu_member.table_member.RescheduleTableMember;
import view.member.menu_member.table_member.TableCartMember;
import view.member.menu_member.transaction_member.AddWallet;
import view.member.menu_member.transaction_member.VoucherPoint;

import java.awt.*;

public class MemberMenu extends JFrame {
    public MemberMenu() {
        initComponents();
            this.setVisible(true);
    }

    private void initComponents() {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Guest Menu");

        JLabel title = new JLabel("Welcome, Member!");
        title.setBounds(500, 20, 700, 60);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 60, 1080, 600);

        JButton bookTableButton = new JButton("Book Table");
        bookTableButton.setBounds(180, 100, 440, 40);
        panel.add(bookTableButton);

        bookTableButton.addActionListener(e -> {
            this.dispose();
            new BookTableForm();
        });

        JButton rescheduleTableButton = new JButton("Reschedule Table");
        rescheduleTableButton.setBounds(180, 150, 440, 40);
        panel.add(rescheduleTableButton);

        rescheduleTableButton.addActionListener(e -> {
            this.dispose();
            new RescheduleTableMember();
        });

        JButton cancelTableButton = new JButton("Cancel Table");
        cancelTableButton.setBounds(180, 200, 440, 40);
        panel.add(cancelTableButton);

        bookTableButton.addActionListener(e -> {
            this.dispose();
            new ViewCancelTableGuest();
        });

        JButton walletButton = new JButton("Wallet");
        walletButton.setBounds(180, 250, 440, 40);
        panel.add(walletButton);

        walletButton.addActionListener(e -> {
            this.dispose();
            new AddWallet();
        });

        JButton profileButton = new JButton("Profile");
        profileButton.setBounds(180, 300, 440, 40);
        panel.add(profileButton);

        profileButton.addActionListener(e -> {
            this.dispose();
            new ViewProfile();
        });

        JButton viewTableOrder = new JButton("View Table Order");
        viewTableOrder.setBounds(660, 100, 440, 40);
        panel.add(viewTableOrder);

        viewTableOrder.addActionListener(e -> {
            this.dispose();
            new TableCartMember(null);
        });

        JButton orderMenuButton = new JButton("Order F&B Menu");
        orderMenuButton.setBounds(660, 150, 440, 40);
        panel.add(orderMenuButton);

        profileButton.addActionListener(e -> {
            this.dispose();
            new OrderFnBMember();
        });

        JButton viewCartButton = new JButton("FnB Cart");
        viewCartButton.setBounds(660, 200, 440, 40);
        panel.add(viewCartButton);

        profileButton.addActionListener(e -> {
            this.dispose();
            new ViewCartMember();
        });

        JButton editProfile = new JButton("Edit Profile Details");
        editProfile.setBounds(660, 200, 440, 40);
        panel.add(editProfile);

        editProfile.addActionListener(e -> {
            this.dispose();
            new EditProfile();
        });

        JButton viewPointButton = new JButton("View Point");
        viewPointButton.setBounds(660, 250, 440, 40);
        panel.add(viewPointButton);

        viewPointButton.addActionListener(e -> {
            this.dispose();
            new VoucherPoint();
        });


        JButton logout = new JButton("Logout");
        logout.setBounds(660, 300, 440, 40);
        panel.add(logout);

        logout.addActionListener(e -> {
            this.dispose();
            new AuthenticationController().logout();
        });

        add(title);
        add(panel);
    }

    public static void main(String[] args) {
        new MemberMenu();
    }
}