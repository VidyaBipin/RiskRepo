// Assuming ctx is some kind of context object with a method getAuthenticatedUserName()
String userName = ctx.getAuthenticatedUserName();
String query = "SELECT * FROM items WHERE owner = '" + userName + "' AND itemname = '" + ItemName + "'";
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(query);
while (rs.next()) {
    // Process the results
}
rs.close();
stmt.close();
