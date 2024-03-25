const sql = require('mssql');

// Simulated input from user
const userInput = "1; DROP TABLE Products;--";

// Construct the SQL query
const sqlQuery = `SELECT * FROM Orders WHERE OrderID = ${userInput}`;

// In a real application, you would execute the query against the database using a database connection
// Replace 'config' with your actual database connection configuration
const config = {
    user: 'your_username',
    password: 'your_password',
    server: 'localhost', // You may need to replace this with your server address
    database: 'your_database',
    options: {
        encrypt: true // For Azure SQL Database
    }
};

// Connect to the database and execute the query
sql.connect(config)
    .then(pool => {
        return pool.request()
            .query(sqlQuery);
    })
    .then(result => {
        console.log('Query results:', result.recordset);
    })
    .catch(err => {
        console.error('Error executing query:', err);
    });
