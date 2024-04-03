import java.sql.*;

public class HealthRecordsAPI {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/example_db";
        String user = "username";
        String password = "password";

        // Establish database connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Prepare SQL statement
            String sql = "SELECT * FROM health_records WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Assuming 'data' is an instance of a class representing request body
            int id = data.getId();
            statement.setInt(1, id);

            // Execute query
            ResultSet resultSet = statement.executeQuery();

            // Process result set
            while (resultSet.next()) {
                // Access result set data, perform necessary operations
                int recordId = resultSet.getInt("id");
                // Retrieve other columns as needed
                // Example: String name = resultSet.getString("name");
                // Example: int age = resultSet.getInt("age");

                // Print or process the retrieved data
                System.out.println("Record ID: " + recordId);
                // Example: System.out.println("Name: " + name);
                // Example: System.out.println("Age: " + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
