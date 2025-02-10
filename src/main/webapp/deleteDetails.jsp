<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Student Details</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>Delete Student Details</h2>
    
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
    <form action="delete" method="POST">
    
        <label for="usn">Enter USN to Delete:</label>
        <input type="text" id="usn" name="usn" required>
        <br><br>
        <input type="submit" value="Delete">
    </form>
    </main>
    
    <footer>
        <p>&copy; 2024 Techmiya Solutions. All Rights Reserved.</p>
    </footer>
    
</body>
</html>
