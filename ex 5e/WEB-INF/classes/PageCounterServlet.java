import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PageCounterServlet extends HttpServlet {
    private int totalVisits = 0; // Counter for total visits (application-wide)

    @Override
    public void init() throws ServletException {
        // Initialize the totalVisits counter if needed
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Session to track user visits
        HttpSession session = request.getSession();
        Integer userVisits = (Integer) session.getAttribute("userVisits");

        if (userVisits == null) {
            userVisits = 1; // First visit for the user
        } else {
            userVisits++; // Increment user visit count
        }
        session.setAttribute("userVisits", userVisits);

        // Increment total visits (application-wide)
        synchronized (this) {
            totalVisits++;
        }

        // Generate response
        out.println("<html><body>");
        out.println("<h1>Welcome to the Page Counter</h1>");
        out.println("<p><strong>Total Visits (All Users):</strong> " + totalVisits + "</p>");
        out.println("<p><strong>Your Visits:</strong> " + userVisits + "</p>");
        out.println("</body></html>");
    }
}
