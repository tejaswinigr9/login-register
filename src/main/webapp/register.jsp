<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Register</title>
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
<h2>Register</h2>
<form action="rs" method="post">

<lable for="username">UserName:</label><br>
<input type="username" id="username" name="username" required><br><br>

<label for="email">Email</label><br>
<input type="email" id="email" name="email" required><br><br>

<label for="password">Password</label><br>
<input type="password" id="password" name="password" required><br><br>

<button type="submit">Register</button>
</form>

<% 
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
    <div class="alert alert-danger"><%= message %></div>
<% 
    }
%>

</main>

 <footer>
        <p>&copy; 2024 Techmiya Solutions. All Rights Reserved.</p>
    </footer>

</body>
</html>