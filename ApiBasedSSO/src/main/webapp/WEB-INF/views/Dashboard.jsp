<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<h2>Welcome to Your Dashboard!</h2>
<!-- Your dashboard content goes here -->
 <!-- Display user information -->
    <p>Hello, ${username}!</p>

    <!-- Dashboard content -->
    <div>
        <!-- Add your specific dashboard content here -->
        <p>Here's some information for the user:</p>
        <ul>
            <li>Recent activities</li>
            <li>Statistics</li>
            <li>Links to various sections</li>
        </ul>
    </div>

    <!-- Logout link -->
    <p><a href="/logout">Logout</a></p>
</body>
</html>

</body>
</html>