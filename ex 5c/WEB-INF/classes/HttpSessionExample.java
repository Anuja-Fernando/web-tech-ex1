import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HttpSessionExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("username", "JohnDoe");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>HttpSession Example</h1>");
        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p>Username stored in session: " + session.getAttribute("username") + "</p>");
        out.println("<a href='dataRetrieval'>Retrieve Data</a>");
        out.println("</body></html>");
    }
}
