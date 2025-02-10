<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="loginregister.Student" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset = "UTF-8">
    <title>Read student Info</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2>Read Student Information</h2>
    
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

<form action="ReadStudentServlet" method="post">

		<table border="1" class="student-info-table" >
            <thead>
                <tr>
                    <th>USN</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>User name</th>
                    <!-- <th>Password</th> -->
                </tr>
            </thead>
            <tbody>
             <% 
            List<Student> studentList = (List<Student>) request.getAttribute("studentList");
           
             if (studentList != null && !studentList.isEmpty()) 
             {
                for (Student student : studentList) 
                {
       		 %>
            			<tr>
                			<td><%= student.getUsn() %></td>
                			<td><%= student.getEmail() %></td>
                			<td><%= student.getPhone() %></td> 
               				<td><%= student.getUsername() %></td>
               				<%-- <td><%= student.getPassword() %></td> --%>
            			</tr>
        <% }
            }
            else
            {%>
            <tr>
                <td colspan="5">No data found</td>
            </tr>
        <%}%>             
       	  </tbody>
        </table>
        
  
     </form>
     
    </main>
    
    <footer>
		<p>&copy; 2024 Techmiya Solutions. All Rights Reserved.
	</footer>
    
	</body>
</html>
