import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HiddenFormFieldExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hidden Form Field Example</h1>");
        out.println("<form action='dataRetrieval' method='post'>");
        out.println("<input type='hidden' name='username' value='JohnDoe'>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
