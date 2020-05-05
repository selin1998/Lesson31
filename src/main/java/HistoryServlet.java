import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryServlet extends HttpServlet {
    List<Storage> history;

    public HistoryServlet(List<Storage> history) {
        this.history=history;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if(cookies==null){
            resp.sendRedirect("/calc/login");
        }

        else{
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("Calc_cookie")){
                    try (PrintWriter writer = resp.getWriter()) {
                        List<Storage> storage = history.stream().filter(i -> i.username.equals(cookie.getValue())).collect(Collectors.toList());
                        storage.stream().forEach(i->writer.println(i.operation));
                    }
                }
            }
        }

    }


}
