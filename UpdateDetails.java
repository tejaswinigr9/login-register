package loginregister;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UpdateDetails extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
        String usn = request.getParameter("usn");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            String url = "jdbc:mysql://localhost:3306/user_db";
            String dbUser = "studentinfo";
            String dbPassword = "root";
            conn = DriverManager.getConnection(url, dbUser, dbPassword);

           
            String updateSQL = "UPDATE studentinfo SET email = ?, phone = ?, username = ?, password = ? WHERE usn = ?";

           
            stmt = conn.prepareStatement(updateSQL);
            stmt.setString(1, email);
            stmt.setString(2, phone);
            stmt.setString(3, username);
            stmt.setString(4, password);
            stmt.setString(5, usn);

          
            int rowsUpdated = stmt.executeUpdate();

          
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            if (rowsUpdated > 0) {
            	 response.sendRedirect("updatesucess.jsp");
				
            } else {
               out.println("<h2>No user found with the given USN: " + usn + "</h2>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error: " + e.getMessage() + "</h2>");

        
        } finally {
         
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
