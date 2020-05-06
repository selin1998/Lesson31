import entities.Storage;
import filters.AuthFilter;
import filters.CookieFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.CalculatorServlet;
import servlets.HistoryServlet;
import servlets.LoginServlet;
import servlets.LogoutServlet;

import javax.servlet.DispatcherType;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

public class ServerApp {
    private static final EnumSet<DispatcherType> ft = EnumSet.of(DispatcherType.REQUEST);
    public static void main(String[] args) throws Exception {
        List<Storage> history=new ArrayList<>();
        HashMap<String, String> login = new HashMap<>();
        Server server=new Server(9000);
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.addServlet(new ServletHolder(new LoginServlet(login)),"/calc/login");
        servletContextHandler.addServlet(new ServletHolder(new CalculatorServlet(history)),"/calc/do");
        servletContextHandler.addServlet(new ServletHolder(new HistoryServlet(history)),"/calc/history");
        servletContextHandler.addServlet(new ServletHolder(new LogoutServlet()),"/calc/logout");
        servletContextHandler.addFilter(CookieFilter.class,"/calc/do",ft);
        servletContextHandler.addFilter(CookieFilter.class,"/calc/logout",ft);
        servletContextHandler.addFilter(CookieFilter.class,"/calc/history",ft);
        servletContextHandler.addFilter(new FilterHolder(new AuthFilter(login)),"/calc/login",ft);
        server.setHandler(servletContextHandler);
        server.start();
        server.join();

    }
}
