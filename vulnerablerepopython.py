# Vulnerable Python code with SQL injection
def search_products(keyword):
    sql_query = "SELECT * FROM products WHERE name LIKE '%" + keyword + "%'"
    # Execute the SQL query (this is just a demonstration and won't actually execute the query)
    print("Executing query:", sql_query)
    # Code to execute the query against the database would be here

# User input (simulated search keyword)
user_input = "'; DROP TABLE products;--"

# Call the vulnerable function with user input
search_products(user_input)
