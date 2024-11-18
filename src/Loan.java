import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loan extends JFrame {
    public Loan() {
        setTitle("Loan Application");
        setSize(702,500);
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
                new Taskbar().setVisible(true);
                Loan.this.dispose();
            }
        });

        menuItemSignOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement sign out functionality here
                new Register().setVisible(true);
                Loan.this.dispose();
            }
        });

        // Create a panel with null layout for custom component positioning
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0x0800FF));
        add(panel);

        JLabel memberIdLabel = new JLabel("Member ID:");
        memberIdLabel.setBounds(180, 5, 150, 25);
        memberIdLabel.setForeground(Color.YELLOW);
        panel.add(memberIdLabel);
        JTextField memberIdField = new JTextField(15);
        memberIdField.setBounds(180, 30, 300, 25);
        memberIdField.setForeground(Color.BLACK);
        memberIdField.setBackground(Color.WHITE);
        panel.add(memberIdField);

        JLabel loanAmountLabel = new JLabel("Loan Amount:");
        loanAmountLabel.setBounds(180, 60, 150, 25);
        loanAmountLabel.setForeground(Color.YELLOW);
        panel.add(loanAmountLabel);
        JTextField loanAmountField = new JTextField(15);
        loanAmountField.setBounds(180, 85, 300, 25);
        loanAmountField.setForeground(Color.BLACK);
        loanAmountField.setBackground(Color.WHITE);
        panel.add(loanAmountField);

        JLabel loanTypeLabel = new JLabel("Loan Type:");
        loanTypeLabel.setBounds(180, 115, 150, 25);
        loanTypeLabel.setForeground(Color.YELLOW);
        panel.add(loanTypeLabel);
        String[] loanTypeOptions = {"Emergency Loan", "Short Loan", "Normal Loan", "Development Loan"};
        JComboBox<String> loanTypeCombo = new JComboBox<>(loanTypeOptions);
        loanTypeCombo.setBounds(180, 140, 300, 25);
        loanTypeCombo.setForeground(Color.BLACK);
        loanTypeCombo.setBackground(Color.WHITE);
        panel.add(loanTypeCombo);

        JLabel interestRateLabel = new JLabel("Interest Rate:");
        interestRateLabel.setBounds(180, 170, 150, 25);
        interestRateLabel.setForeground(Color.YELLOW);
        panel.add(interestRateLabel);
        String[] interestRateOptions = {"0.3%", "0.6%", "1.0%", "1.4%"};
        JComboBox<String> interestRateCombo = new JComboBox<>(interestRateOptions);
        interestRateCombo.setBounds(180, 195, 300, 25);
        interestRateCombo.setForeground(Color.BLACK);
        interestRateCombo.setBackground(Color.WHITE);
        panel.add(interestRateCombo);

        JLabel repaymentPeriodLabel = new JLabel("Repayment Period:");
        repaymentPeriodLabel.setBounds(180, 225, 150, 25);
        repaymentPeriodLabel.setForeground(Color.YELLOW);
        panel.add(repaymentPeriodLabel);
        String[] repaymentPeriodOptions = {"1 year", "2 years", "3 years", "4 years"};
        JComboBox<String> repaymentPeriodCombo = new JComboBox<>(repaymentPeriodOptions);
        repaymentPeriodCombo.setBounds(180, 250, 300, 25);
        repaymentPeriodCombo.setForeground(Color.BLACK);
        repaymentPeriodCombo.setBackground(Color.WHITE);
        panel.add(repaymentPeriodCombo);

        JLabel guarantorLabel = new JLabel("Guarantor:");
        guarantorLabel.setBounds(180, 280, 150, 25);
        guarantorLabel.setForeground(Color.YELLOW);
        panel.add(guarantorLabel);
        JTextField guarantorField = new JTextField(15);
        guarantorField.setBounds(180, 305, 300, 25);
        guarantorField.setForeground(Color.BLACK);
        guarantorField.setBackground(Color.WHITE);
        panel.add(guarantorField);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(290, 350, 100, 25);
        btnSubmit.setForeground(Color.BLACK);
        btnSubmit.setBackground(Color.WHITE);
        btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(btnSubmit);

        // Add ActionListener to loanTypeCombo
        loanTypeCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLoanType = loanTypeCombo.getSelectedItem().toString();
                if (selectedLoanType.equals("Emergency Loan")) {
                    // Set interest rate to 0.3% and repayment period to 1 year
                    interestRateCombo.setSelectedItem("0.3%");
                    repaymentPeriodCombo.setSelectedItem("1 year");
                }else if (selectedLoanType.equals("Short Loan")) {
                    interestRateCombo.setSelectedItem("0.6%");
                    repaymentPeriodCombo.setSelectedItem("2 years");
                } else if (selectedLoanType.equals("Normal Loan")) {
                     interestRateCombo.setSelectedItem("1.0%");
                     repaymentPeriodCombo.setSelectedItem("3 years");
                }else if (selectedLoanType.equals("Development Loan")) {
                    interestRateCombo.setSelectedItem("1.4%");
                    repaymentPeriodCombo.setSelectedItem("4 years");
                }
            }
        });

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = memberIdField.getText();
                String loanAmount = loanAmountField.getText();
                String loanType = loanTypeCombo.getSelectedItem().toString();
                String interestRate = interestRateCombo.getSelectedItem().toString();
                String repaymentPeriod = repaymentPeriodCombo.getSelectedItem().toString();
                String guarantor = guarantorField.getText();

                // Check if the fields are empty
                if (memberId.isEmpty() || loanAmount.isEmpty() || loanType.isEmpty() || interestRate.isEmpty() || repaymentPeriod.isEmpty() || guarantor.isEmpty()) {
                    JOptionPane.showMessageDialog(Loan.this,"Please fill all the fields");
                }
                try {
                    FedhaDatabase.inserLoan(memberId,loanAmount,loanType,interestRate,repaymentPeriod,guarantor);
                    JOptionPane.showMessageDialog(Loan.this,"Loan successfully applied");
                    Taskbar taskbar = new Taskbar();
                    taskbar.setVisible(true);
                    Loan.this.dispose();
                } catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(Loan.this, "An error occurred while applying loan.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Loan();
            }
        });
    }
}
