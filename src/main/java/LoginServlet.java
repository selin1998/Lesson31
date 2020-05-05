import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    Map<String, String> login;
    public LoginServlet(HashMap<String, String> login) {
        this.login=login;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (OutputStream os = resp.getOutputStream()) {
            Files.copy(Paths.get("content/login.html"), os);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("username");
        String password=req.getParameter("password");

        try (PrintWriter writer = resp.getWriter()) {
            writer.printf("%s logged in successfully",name);
            Cookie cookie=new Cookie("Calc_cookie",name);
            cookie.setPath("/calc");
            resp.addCookie(cookie);


        }
    }
}
