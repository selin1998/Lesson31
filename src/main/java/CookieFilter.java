import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieFilter implements Filter {

    private boolean isHttp(ServletRequest request, ServletResponse response) {
        return request instanceof HttpServletRequest && response instanceof HttpServletResponse;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        if(cookies==null) ((HttpServletResponse)servletResponse).sendRedirect("/calc/login");
        else if(isHttp(servletRequest,servletResponse)){
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
