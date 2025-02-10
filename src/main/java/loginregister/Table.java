package loginregister;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Table")
public class Table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Table() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","root");
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM studentinfo");
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			out.println("<table ");
			out.println("<tr>");
			out.println("<th> ");
			out.println("USN");
			out.println("</th>");
			out.println("<th>");
			out.println("Email ");
			out.println("</th>");
			out.println("<th>");
			out.println("Phone");
			out.println("</th>");
			out.println("<th>");
			out.println("Username");
			out.println("</th>");
			out.println("<th>");
			out.println("Password");
			out.println("</th>");
			out.println("/tr");
			
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td> ");
				out.println(rs.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(3));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(4));
				out.println("</td>");
				out.println("<td>");
				out.println(rs.getString(5));
				out.println("</td>");
				out.println("/tr");
			}
			out.println("</table>");
			
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}

