import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class FedhaDatabase {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/fedha_youth_group_schema";
    private static final String username = "root";
    private static final String password = "Mousa@muigai123!";

    public static Connection connect() throws SQLException, ClassNotFoundException {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Establish connection
        return getConnection(jdbcUrl, username, password);
    }
    // Start of User Data
    public static boolean userExists(String username, String email) {
        String sql = "SELECT * FROM users WHERE username = ? OR email = ?";
        try (Connection connection = connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();  // If a result is returned, the user exists
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void insertUser(String username, String email, String password) {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        try (Connection connection = connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // Set parameters
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);

            // Execute the insert command
            pstmt.executeUpdate();
            System.out.println("User inserted successfully!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Insert failed");
            e.printStackTrace();
        }
    }
    public static boolean checkCredentials(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection connection = connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            // If a result is returned, the user exists
            return rs.next();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    // End of User Data

    // Start of Member Data
    public static void insertMember(String surname,String otherNames,String day,String month,String year,String phone, String email,String memberId,String registrationFees,String status) {
        String sql = "INSERT INTO members (surname,otherNames,day,month,year,phone,email,memberId,registrationFees,status) VALUES (?, ?, ?,?,?,?,?,?,?,?)";
        try (Connection connection = connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // Set parameters
            pstmt.setString(1, surname);
            pstmt.setString(2, otherNames);
            pstmt.setString(3, day);
            pstmt.setString(4, month);
            pstmt.setString(5, year);
            pstmt.setString(6, phone);
            pstmt.setString(7, email);
            pstmt.setString(8, memberId);
            pstmt.setString(9, registrationFees);
            pstmt.setString(10, status);
            // Execute the insert command
            pstmt.executeUpdate();
            System.out.println("Member added successfully!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Member failed");
            e.printStackTrace();
        }
    }
    // End of Member Data

    // Start of Loan Data
    public static void inserLoan(String memberId, String loanAMount, String loanType, String interestRate, String repaymentPeriod, String guarantor) {
        String sql = "INSERT INTO loans (memberId,loanAmount,loanType,interestRate,repaymentPeriod,guarantor) VALUES (?,?,?,?,?,?)";
        try (Connection connection = connect(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // Set parameters
            pstmt.setString(1,memberId );
            pstmt.setString(2,loanAMount);
            pstmt.setString(3,loanType);
            pstmt.setString(4,interestRate);
            pstmt.setString(5,repaymentPeriod);
            pstmt.setString(6,guarantor);
            // Execute the insert command
            pstmt.executeUpdate();
            System.out.println("Loan applied successfully!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Loan failed");
            e.printStackTrace();
        }
    }
    public static boolean isMemberIdExists(String memberId) throws SQLException, ClassNotFoundException {
        String query = "SELECT COUNT(*) FROM members WHERE memberId = ?";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, memberId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;  // Returns true if memberId exists
                }
            }
        }
        return false;
    }
    // End of Loan Data
}
