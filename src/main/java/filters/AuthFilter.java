package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class AuthFilter implements Filter {
    Map<String, String> login;

    public AuthFilter(Map<String, String> login) {
        this.login = login;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    private boolean isEmpty(String name, String password){
        return name.isEmpty()||password.isEmpty();

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(((HttpServletRequest) servletRequest).getMethod().equals("POST")){
            Map<String, String[]> allParams = servletRequest.getParameterMap();
            boolean all =
                    allParams.containsKey("username") &&
                            allParams.containsKey("password");

            if(all){
                String name = servletRequest.getParameter("username");
                String password = servletRequest.getParameter("password");

                if((!isEmpty(name,password))&&(!login.containsKey(name)||(login.get(name).equals(password)))){
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                else{
                    PrintWriter writer= servletResponse.getWriter();
                    writer.println("This username is already taken or you did not entered credentials at all!");
                }

            }


        }
        else filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
