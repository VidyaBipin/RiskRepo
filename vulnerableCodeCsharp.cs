using System;

class Program
{
    // Vulnerable C# code with SQL injection
    static void SearchProducts(string keyword)
    {
        string sqlQuery = "SELECT * FROM products WHERE name LIKE '%" + keyword + "%'";
        // Execute the SQL query (this is just a demonstration and won't actually execute the query)
        Console.WriteLine("Executing query: " + sqlQuery);
        // Code to execute the query against the database would be here
    }

    static void Main(string[] args)
    {
        // User input (simulated search keyword)
        string userInput = "'; DROP TABLE products;--";

        // Call the vulnerable function with user input
        SearchProducts(userInput);
    }
}
