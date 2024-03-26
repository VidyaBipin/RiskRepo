const { Client } = require('pg');

// Simulated user input
const userInput = "'; DROP TABLE users; --";

// Call the vulnerable function with user input
searchProducts(userInput);

function searchProducts(keyword) {
    // Simulated database connection
    const client = new Client({
        user: 'user',
        host: 'localhost',
        database: 'mydatabase',
        password: 'password',
        port: 5432,
    });

    client.connect();

    // Vulnerable SQL query with concatenation
    const sqlQuery = "SELECT * FROM products WHERE name LIKE '%" + keyword + "%'";
    // Log the query (this is just for demonstration)
    console.log("Executing query: " + sqlQuery);

    // Vulnerable execution of SQL query (This is just for demonstration and should not be done in production)
    client.query(sqlQuery, (err, res) => {
        if (err) {
            console.error(err); // Log the error
        } else {
            for (let row of res.rows) {
                console.log("ID:", row.id, "Name:", row.name);
            }
        }
        client.end();
    });
}
