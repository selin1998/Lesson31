import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HistoryServlet extends HttpServlet {
    Storage s;
    public HistoryServlet(Storage storage) {
        this.s=storage;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();


        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("Calc_cookie")){
                    try (PrintWriter writer = resp.getWriter()) {
                        writer.println(s.getAllbyUser(cookie.getValue()).get());
                    }
                }
            }
        }
        else{
            resp.sendRedirect("/calc/login");
        }

    }


}
