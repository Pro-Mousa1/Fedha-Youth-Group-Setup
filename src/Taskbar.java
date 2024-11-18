import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Taskbar extends JFrame{
    private String registeredUsername;
    private String registeredPassword;
    public Taskbar(){
        setTitle("Fedha Taskbar");
        setSize(702,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create menu
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);

        // Create menu items
        JMenuItem menuItemGoBack = new JMenuItem("Back");
        JMenuItem menuItemSignOut = new JMenuItem("Sign Out");

        // Add menu items to menu
        menu.add(menuItemGoBack);
        menu.add(menuItemSignOut);

        menuItemGoBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement go back functionality here
                new Login(registeredUsername, registeredPassword).setVisible(true);
                Taskbar.this.dispose();
            }
        });

        menuItemSignOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement sign out functionality here
                new Register().setVisible(true);
                Taskbar.this.dispose();
            }
        });

        // Create a panel with null layout for custom component positioning
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0x0CFFD9));
        add(panel);

        JButton btnMember=new JButton("Member");
        btnMember.setBounds(0, 0, 100, 30);
        btnMember.setBackground(new Color(0xCDD2D6));
        panel.add(btnMember);

        JButton btnLoan=new JButton("Loan");
        btnLoan.setBounds(100, 0, 100, 30);
        btnLoan.setBackground(new Color(0xCDD2D6));
        panel.add(btnLoan);

        JButton btnLoanRecords=new JButton("Records");
        btnLoanRecords.setBounds(200, 0, 100, 30);
        btnLoanRecords.setBackground(new Color(0xCDD2D6));
        panel.add(btnLoanRecords);

        JButton btnFixedDeposits=new JButton("Deposits");
        btnFixedDeposits.setBounds(300, 0, 100, 30);
        btnFixedDeposits.setBackground(new Color(0xCDD2D6));
        panel.add(btnFixedDeposits);

        JButton btnShares=new JButton("Shares");
        btnShares.setBounds(400, 0, 100, 30);
        btnShares.setBackground(new Color(0xCDD2D6));
        panel.add(btnShares);

        btnMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Members members=new Members();
                Taskbar.this.dispose();
            }
        });

        btnLoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loan loan=new Loan();
                loan.setVisible(true);
                Taskbar.this.dispose();
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Taskbar();
            }
        });
    }
}
