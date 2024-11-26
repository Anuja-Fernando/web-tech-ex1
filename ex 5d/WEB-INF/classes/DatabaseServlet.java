import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DatabaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/hospital";
        String dbUser = "root";
        String dbPassword = "password";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Patient Records</h1>");

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // SQL query
            String sql = "SELECT * FROM patients";

            // Execute query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Display data
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>Gender</th></tr>");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + age + "</td>");
                out.println("<td>" + gender + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

            // Close connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }

        out.println("</body></html>");
    }
}
