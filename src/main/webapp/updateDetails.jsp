<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update User Info</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>Update User Information</h2>
    
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
    
    <form action="update" method="post">
    
       <label for="usn">USN:</label>
        <input type="text" name="usn" id="usn" required><br><br>

        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required><br><br>

        <label for="phone">Phone:</label>
        <input type="text" name="phone" id="phone"><br><br>

        <label for="username">Username:</label>
        <input type="text" name="username" id="username" required><br><br>

        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required><br><br>

       <button type="submit">Update</button>
    </form>
    </main>
    
    <footer>
<p>&copy; 2024 Techmiya Solutions. All Rights Reserved.</footer>
    
</body>
</html>
