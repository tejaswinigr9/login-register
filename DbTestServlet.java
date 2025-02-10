package loginregister;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DbTest")
public class DbTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DbTestServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db", "root", "root123");
            
            // If connection is successful, print a success message
            response.getWriter().println("Connected to the database successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            response.getWriter().println("Error connecting to the database: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
