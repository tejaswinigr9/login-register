package loginregister;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
	     
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC Driver loaded succesfully");
		}
		catch(ClassNotFoundException e)
		{
			req.setAttribute("message", "JDBC Driver not found");
			req.getRequestDispatcher("register.jsp").forward(req, res);
            return;		
		}
		
	
	String username=req.getParameter("username");
	String password=req.getParameter("password");
	
	 if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
         res.sendRedirect("login.jsp?error=Please fill out all fields");
         return; 
	 }
	
	try {
		System.out.println("login servlet function is called");
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","root123");
        String query="SELECT * FROM studentinfo WHERE username=?";
        PreparedStatement stat=conn.prepareStatement(query);
        		stat.setString(1, username);
        ResultSet rs=stat.executeQuery();
        
        if(rs.next()) {
        	String storedPassword=rs.getString("password");
        	
        			if(BCrypt.checkpw(password,storedPassword)) {
        				HttpSession sess=req.getSession();
        				sess.setAttribute("username", username);
        				System.out.println("calling dashboard = " + username);
        				res.sendRedirect("dashboard.jsp?usn = " + username);
        			}
        			else {
        				res.sendRedirect("login.jsp?error=Invalid credentials");
        			}
        	
	}else {
		res.sendRedirect("login.jsp?error=User not found");
	}
	}
	catch(SQLException e) {
		e.printStackTrace();
		res.sendRedirect("login.jsp?error=Database error");
}
}
}