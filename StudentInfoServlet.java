package loginregister;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentInfoServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC Driver loaded succesfully");
		}
		catch(ClassNotFoundException e)
		{
			req.setAttribute("message", "JDBC Driver not found");
			req.getRequestDispatcher("Studentinfo.jsp").forward(req, res);
            return;		
		}
	
    String usn=req.getParameter("usn");
    String email=req.getParameter("email");
    String phone=req.getParameter("phone");
    String username=req.getParameter("username");
    String password=req.getParameter("password");
    
    if (usn == null || usn.trim().isEmpty() || 
            email == null || email.trim().isEmpty() || 
            phone == null || phone.trim().isEmpty() || 
            username == null || username.trim().isEmpty() || 
            password == null || password.trim().isEmpty()) {
            
    	req.setAttribute("error","Empty fields are not allowed");
    	req.getRequestDispatcher("Studentinfo.jsp").forward(req, res);
        return;
    }
    
    String hashedPassword=BCrypt.hashpw( password,BCrypt.gensalt(12));
    Connection conn = null;
    PreparedStatement stat=null;
    
    
    try {
    	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","root123");
    	
    	String query="INSERT INTO studentinfo (usn, email, phone, username, password) VALUES(?, ?, ?, ?, ?)";
    	stat=conn.prepareStatement(query);
    	stat.setString(1, usn);
    	stat.setString(2, email);
    	stat.setString(3, phone);
    	stat.setString(4, username);
    	stat.setString(5, hashedPassword);
    	
    	int rowsAffected = stat.executeUpdate();
    	if (rowsAffected > 0) {
    		res.sendRedirect("regcomp.jsp");
    	} else {
    		res.sendRedirect("Studentinfo.jsp?error=Unable to save");
    	}
    	
    } catch(SQLException e) {
    	e.printStackTrace();
    	res.sendRedirect("Studentinfo.jsp?error=Database error");
    }	finally {
    	try {
    		if(stat!= null) {
    			stat.close();
    		}
    		if(conn!= null) {
    			conn.close();
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
		
	}

}
