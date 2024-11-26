import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class URLRewritingExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("username", "JohnDoe");

        String url = response.encodeURL("dataRetrieval");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>URL Rewriting Example</h1>");
        out.println("<a href='" + url + "'>Go to Data Retrieval</a>");
        out.println("</body></html>");
    }
}
