<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
  <style>
       
        body, h2, p, a {
            margin: 0;
            padding: 0;
            font-family: 'Arial', sans-serif;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(to right, #f5f7fa, #c3cfe2);
            color: #333;
            text-align: center;
            flex-direction: column;
        }

        h2 {
            font-size: 2.5em;
            color: #444;
            margin-bottom: 20px;
        }

        p {
            font-size: 1.2em;
            color: #555;
        }

        a {
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            padding: 12px 24px;
            font-size: 1.2em;
            border-radius: 5px;
            margin-top: 20px;
            display: inline-block;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        a:hover {
            background-color: #45a049;
            transform: translateY(-3px);
        }

        .content {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 500px;
        }

        @media screen and (max-width: 600px) {
            h2 {
                font-size: 2em;
            }

            p {
                font-size: 1em;
            }

            a {
                font-size: 1em;
                padding: 10px 20px;
            }
        }
    </style>

</head>
<body>
<%
session.invalidate();
%>
<h2> You have been logged out successfully.</h2>
<p><a href="login.jsp">Click here to login again.</a></p>

</body>
</html>