package loginregister;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String usn = request.getParameter("usn");

    
        String dbURL = "jdbc:mysql://localhost:3306/user_db";
        String dbUsername = "root";
        String dbPassword = "root123"; 

        String deleteSQL = "DELETE FROM studentinfo WHERE usn = ?";

        try (Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword)) {
         
            try (PreparedStatement ps = conn.prepareStatement(deleteSQL)) {
       
                ps.setString(1, usn);

             
                int rowsAffected = ps.executeUpdate();

              
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                if (rowsAffected > 0) {
					/* response.sendRedirect("deletesucess.jsp"); */
					
					  out.println("<h3>Student with USN: " + usn +
					  " has been successfully deleted.</h3>");
					 
                } else {
                    out.println("<h3>No student found with USN: " + usn + ". </h3> <a href='dashboard.jsp'>Dashboard</a>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error: Unable to delete record. Please try again later.</h2>");
        }
    }
}
