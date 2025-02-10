<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<header>

<nav>
   <ul>
      <li><a href="index.jsp">Home</a></li>
      <li><a href="logout.jsp">Logout</a></li>
      <li><a href="register.jsp">Register</a></li>
  </ul>
</nav>
</header>

<main>
<h2>Login</h2>

<% 
        String errorMessage = request.getParameter("error");
        if (errorMessage != null) { 
    %>
        <div style="color: red;"> <%= errorMessage %> </div>
    <% } %>

<form action="ls" method="post">

<label for="username">UserName:</label><br>
<input type="username" id="username" name="username" required><br><br>


<label for="password">Password</label><br>
<input type="password" id="password" name="password" required><br><br>

<button type="submit">Login</button>
</form>

</main>

<footer>
<p>&copy; 2024 Techmiya Solutions. All Rights Reserved.</footer>

</body>
</html>