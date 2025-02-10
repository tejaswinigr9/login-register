package loginregister;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet
{	
		private static final String DB_URL = "jdbc:mysql://localhost:3306/user_db";
		private static final String DB_USER = "root";
		private static final String DB_PASSWORD = "root123";
	
		protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			req.setAttribute("message", "JDBC Driver not found");
			req.getRequestDispatcher("register.jsp").forward(req, res);
            return;		
		}
		
	String email=req.getParameter("email");
	String username=req.getParameter("username");
	String password=req.getParameter("password");
	
	if(email==null || username==null || password==null) {
	    req.setAttribute("message", "All fields are required!");
	    req.getRequestDispatcher("register.jsp").forward(req, res);
	    return;
	}
		String hashedPassword=BCrypt.hashpw(password, BCrypt.gensalt(12));
	
	
try (
 Connection conn=DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD)){

	String sql="INSERT INTO studentinfo(email,username,password) VALUES(?, ?, ?)";
 try(PreparedStatement stat=conn.prepareStatement(sql)){
   stat.setString(1, email);
		 stat.setString(2, username);
		 stat.setString(3, hashedPassword);

		 int result=stat.executeUpdate();
		  if(result>0) {
			  res.sendRedirect("success.jsp");
		  }else {
			  req.setAttribute("message", "Registration failed.Please try again.");
		  req.getRequestDispatcher("register.jsp").forward(req, res);
		  }
		}
 
 catch (SQLIntegrityConstraintViolationException e) {
     
     e.printStackTrace();
     req.setAttribute("message", "The email or username is already in use. Please try a different one.");
     req.getRequestDispatcher("register.jsp").forward(req, res);
 } 
 catch(SQLException e) {
			e.printStackTrace();
			String errorMessage="Database error" + e.getMessage();
			req.setAttribute("message",errorMessage);
			req.getRequestDispatcher("register.jsp").forward(req,res);
	     
		}
}catch(SQLException e) {
	e.printStackTrace();
	req.setAttribute("message","Database error occured.Please try again");
	req.getRequestDispatcher("register.jsp").forward(req, res);
}
}
}