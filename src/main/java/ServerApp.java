import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {

    public static void main(String[] args) throws Exception {
        Storage s=new Storage();
        Server server=new Server(9000);
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.addServlet(new ServletHolder(new LoginServlet()),"/calc/login");
        servletContextHandler.addServlet(new ServletHolder(new CalculatorServlet(s)),"/calc/do");
        servletContextHandler.addServlet(new ServletHolder(new HistoryServlet(s)),"/calc/history");
        servletContextHandler.addServlet(new ServletHolder(new LogoutServlet()),"/calc/logout");

        server.setHandler(servletContextHandler);
        server.start();
        server.join();

    }
}
