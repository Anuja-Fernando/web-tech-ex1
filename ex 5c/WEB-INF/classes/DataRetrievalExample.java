import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DataRetrievalExample extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessionUsername = (String) session.getAttribute("username");

        String cookieUsername = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    cookieUsername = cookie.getValue();
                }
            }
        }

        String hiddenUsername = request.getParameter("username");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Data Retrieved</h1>");
        out.println("<p>Session Username: " + sessionUsername + "</p>");
        out.println("<p>Cookie Username: " + cookieUsername + "</p>");
        out.println("<p>Hidden Form Username: " + hiddenUsername + "</p>");
        out.println("</body></html>");
    }
}
