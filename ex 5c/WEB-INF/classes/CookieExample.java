import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("username", "JohnDoe");
        cookie.setMaxAge(60 * 60); // 1 hour
        response.addCookie(cookie);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Cookie Example</h1>");
        out.println("<p>Cookie 'username' has been set.</p>");
        out.println("<a href='dataRetrieval'>Retrieve Data</a>");
        out.println("</body></html>");
    }
}
