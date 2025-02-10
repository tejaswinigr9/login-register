<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

  header{
	background-color:#4CAF50;
	padding:15px;
	text-align:center;
}
header nav ul{
	list-style:none;
	padding:0;
}
header nav ul li{
	display: inline;
	margin-right: 20px;
}
header nav ul li a{
	color: white;
	text-decoration:none;
	font-size:18px;
}

footer {
        background-color: #333;
        color: white;
        text-align: center;
        padding: 10px 0;
        position: fixed;
        bottom: 0;
        width: 100%;
    }

    main {
        padding: 20px;
        background-color: white;
        max-width: 900px;
        margin: 20px auto;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    h2 {
        color: #333;
        font-size: 24px;
        margin-bottom: 15px;
    }

    p {
        color: #555;
        font-size: 16px;
        margin-bottom: 20px;
    }

    div {
        margin-bottom: 20px;
    }

    div a {
        display: inline-block;
        background-color: #007BFF;
        color: white;
        padding: 10px 20px;
        text-decoration: none;
        border-radius: 5px;
        margin: 5px 0;
        transition: background-color 0.3s;
    }

    div a:hover {
        background-color: #0056b3;
    }

    footer {
        text-align: center;
        padding: 10px 0;
        background-color: #333;
        color: white;
        position: absolute;
        width: 100%;
        bottom: 0;
    }

    
</style>


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
<%
String username=(String) session.getAttribute("username");
if(username==null){
	response.sendRedirect("login.jsp?error=Please login first");
	return;
}
%>
 <h2>Welcome to the Dashboard, <%= username %>!</h2>
 
 <p>Here you can manage your account and view your details.</p>
    
    <div>
        <a href="Studentinfo.jsp">Create New Details</a><br>
        
        <a href="readDetails1.jsp">View Student Details</a><br>
        <form action="ReadStudentServlet" method="post">
			<button type="submit">View</button>
		</form>
		
        <a href="updateDetails.jsp">Update Student Details</a><br>
        <a href="deleteDetails.jsp">Delete Student Details</a><br>
    </div>
    
    <div>
        <a href="logout.jsp">Logout</a>
    </div>
</main>

 <footer>
        <p>&copy; 2024 Techmiya Solutions. All Rights Reserved.</p>
    </footer>

</body>
</html>