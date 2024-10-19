import java.sql.*;

public class PreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/klu";
        String username = "root";
        String password = "ayazsalaar786";

        try {
            // Establish the connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create a prepared statement
            String query = "INSERT INTO student (name, age) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            // Set the parameters
            pstmt.setString(1, "John");
            pstmt.setInt(2, 20);

            // Execute the prepared statement
            int rowsAffected = pstmt.executeUpdate();

            System.out.println("Rows affected: " + rowsAffected);

            // Close the resources
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
