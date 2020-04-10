import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String a=req.getParameter("a");
        String b=req.getParameter("b");
        String op=req.getParameter("op");

        Calculator calc=new Calculator();
        try(PrintWriter pw=resp.getWriter()){
            pw.printf("a: %s\n",a);
            pw.printf("b: %s\n",b);
            pw.printf("operation: %s", op);
            pw.println();
            pw.println(calc.calculate(a,b,op));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
