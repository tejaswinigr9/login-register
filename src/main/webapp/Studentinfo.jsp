<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Info</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
<nav>
<ul>
<li><a href="index.jsp">Home</a></li>
<li><a href="login.jsp">Login</a></li>
<li><a href="register.jsp">Register</a></li>
</ul>
</nav>
</header>

<main>
<h2>Student Information</h2>

<% 
        String errorMessage = request.getParameter("error");
        String successMessage = request.getParameter("message");
        if (errorMessage != null) { 
    %>
        <div style="color: red;"> <%= errorMessage %> </div>
    <% } else if (successMessage != null) { %>
        <div style="color: green;"> <%= successMessage %> </div>
    <% } %>

<form action="StudentInfoServlet" method="post">

    <label for="usn">USN:</label><br>
    <input type="text" id="usn" name="usn" required><br><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" required><br><br>

    <label for="phone">Phone Number:</label><br>
    <input type="text" id="phone" name="phone" required><br><br>

<label for="username">User name:</label><br>
<input type="text" id="username" name="username" required><br><br>

<label for="password">Password:</label><br>
    <input type="password" id="password" name="password" required><br><br>
    
    <input type="submit" value="submit">
    
</form>

<br>
<a href="dashboard.jsp">Back to Dashboard</a>

</main>

<footer>
<p>&copy; 2024 Techmiya Solutions. All Rights Reserved.</p>
</footer>

</body>
</html>