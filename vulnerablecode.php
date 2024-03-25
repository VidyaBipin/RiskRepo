<?php
// Connection parameters
$servername = "localhost";
$username = "username";
$password = "password";
$database = "dbname";

// Create connection
$conn = new mysqli($servername, $username, $password, $database);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Check if the search form is submitted
if (isset($_POST['search'])) {
    // Retrieve search query from the form
    $search_query = $_POST['search'];

    // SQL query with vulnerability
    $sql = "SELECT * FROM products WHERE name LIKE '%$search_query%'";

    // Execute the query
    $result = $conn->query($sql);

    // Display search results
    if ($result->num_rows > 0) {
        while($row = $result->fetch_assoc()) {
            echo "Product Name: " . $row["name"]. "<br>";
            echo "Price: " . $row["price"]. "<br>";
            echo "<br>";
        }
    } else {
        echo "No products found.";
    }
}

$conn->close();
?>
<!DOCTYPE html>
<html>
<head>
    <title>Search Products</title>
</head>
<body>
    <h2>Search Products</h2>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
        Search: <input type="text" name="search"><br>
        <input type="submit" value="Search">
    </form>
</body>
</html>
