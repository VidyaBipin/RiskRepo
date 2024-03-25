using System;
using System.Data.SqlClient;

class Program
{
    static void Main(string[] args)
    {
        // Simulated input from user
        string userInput = "1; DROP TABLE Products;--";

        // Construct the SQL query
        string sqlQuery = $"SELECT * FROM Orders WHERE OrderID = {userInput}";

        // Execute the SQL query (this is just a demonstration and won't actually execute the query)
        Console.WriteLine("Executing query: " + sqlQuery);

        // In a real application, you would execute the query against the database using a database connection
        string connectionString = "Your_Connection_String_Here"; // Replace this with your actual connection string

        using (SqlConnection connection = new SqlConnection(connectionString))
        {
            SqlCommand command = new SqlCommand(sqlQuery, connection);
            connection.Open();
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                Console.WriteLine(reader.GetString(0)); // Assuming the first column is a string, adjust as per your table schema
            }
            reader.Close();
        }
    }
}
