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

public class CalculatorServlet extends HttpServlet {
    Calculator calc=new Calculator();
    Storage s;

    public CalculatorServlet(Storage s) {
        this.s = s;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookie=req.getCookies();
        if(cookie==null){
            resp.sendRedirect("/calc/login");
        }
        else { try (OutputStream os = resp.getOutputStream()) {
            Files.copy(Paths.get("content/calc.html"), os);
        }}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a=req.getParameter("x");
        String b=req.getParameter("y");
        String op=req.getParameter("op");
        PrintWriter writer=resp.getWriter();
        writer.println(calc.doOperation(a,b,op));
        Cookie[] cookies = req.getCookies();
        History history=new History(cookies[0].getValue());
        Operation oper=new Operation(a,b,op,calc.doOperation(a,b,op));
        history.addOperation(oper);
        s.saveHistory(cookies[0].getValue(),history);



    }
}
