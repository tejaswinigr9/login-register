package loginregister;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*@WebServlet("/ReadStudentServlet")*/
public class ReadStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> studentList = new ArrayList<>();
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;

		System.out.println("studentlist displayed");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("JDBC Driver loaded succesfully");

			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "root123");
		      stmt = conn.createStatement();
			System.out.println("Connected to database succesfully.");

			 rs = stmt.executeQuery("SELECT * FROM studentinfo");

			if (!rs.isBeforeFirst()) {
				System.out.println("No data returned from database");
			} else {
				System.out.println("Data fetched from database.");
			}

			while (rs.next()) {
				String usn = rs.getString("usn");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String username = rs.getString("username");
				String password = rs.getString("password");

				Student student = new Student(usn, email, phone, username, password);
				studentList.add(student);
			}

			System.out.println(studentList);
			for (Student student : studentList) {
				System.out.println(student.getUsn());
			}

			if (studentList != null && !studentList.isEmpty()) {
				request.setAttribute("studentList", studentList);
				System.out.println(studentList + " till here i'm working");
			} else {
				request.setAttribute("message", "No data found.");
			}

			request.getRequestDispatcher("/readDetails1.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured: " + e.getMessage());
			request.setAttribute("message", "Database error: " + e.getMessage());
		}
		finally {
	        
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch(SQLException e) {
	        	e.printStackTrace();
	        }
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
