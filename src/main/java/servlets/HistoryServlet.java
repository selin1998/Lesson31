package servlets;

import entities.Operation;
import entities.Storage;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryServlet extends HttpServlet {
    private TemplateEngine engine;
    List<Storage> history;

    public HistoryServlet(List<Storage> history,TemplateEngine engine) {
        this.history=history;
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        HashMap<String, Object> data = new HashMap<>();
        List<Operation> operations=new ArrayList<>();
        for (Cookie cookie : cookies) {
            operations = history.stream().filter(i -> i.username.equals(cookie.getValue())).map(o -> o.operation).collect(Collectors.toList());
        }
        data.put("operations",operations);
        engine.render("dynamic2.ftl", data, resp);

    }


}
