// Vulnerable JavaScript code with SQL injection
function searchProducts(keyword) {
    var sqlQuery = "SELECT * FROM products WHERE name LIKE '%" + keyword + "%'";
    // Execute the SQL query (this is just a demonstration and won't actually execute the query)
    console.log("Executing query: " + sqlQuery);
    // Code to execute the query against the database would be here
}

// User input (simulated search keyword)
var userInput = "'; DROP TABLE products;--";

// Call the vulnerable function with user input
searchProducts(userInput);
