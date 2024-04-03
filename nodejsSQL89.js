// Assuming ctx is some kind of context object with a method getAuthenticatedUserName()
let userName = ctx.getAuthenticatedUserName();
let query = "SELECT * FROM items WHERE owner = '" + userName + "' AND itemname = '" + ItemName + "'";
connection.query(query, (err, rows) => {
    if (err) throw err;
    // Process the results
});
