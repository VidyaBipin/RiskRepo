import java.sql.*;

public class SQLInjectionDemo {
    public static void main(String[] args) {
        // Simulated user input
        String userInput = "'; DROP TABLE products;--";

        // Call the vulnerable function with user input
        searchProducts(userInput);
    }

    public static void searchProducts(String keyword) {
        // Simulated database connection
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Vulnerable SQL query with concatenation
            String sqlQuery = "SELECT * FROM products WHERE name LIKE '%" + keyword + "%'";
            // Print the query (this is just for demonstration)
            System.out.println("Executing query: " + sqlQuery);

            // Vulnerable execution of SQL query (This is just for demonstration and should not be done in production)
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            
            // Process the result set (This is just for demonstration)
            while (rs.next()) {
                // Retrieve data from result set
                int id = rs.getInt("id");
                String name = rs.getString("name");
                // Display values
                System.out.println("ID: " + id + ", Name: " + name);
            }
            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
