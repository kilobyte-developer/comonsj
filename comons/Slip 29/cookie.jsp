import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieDemo")
public class CookieDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;

   
    public CookieDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String s = request.getParameter("sub");

        Cookie c = new Cookie("sub", null);
        out.println("Reset....");
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String s = request.getParameter("sub");

        Cookie c1 = new Cookie("sub", s);
        out.println("You have selected the subject: " + c1.getValue());
    }
}
