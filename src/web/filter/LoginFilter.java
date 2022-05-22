package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        if (uri.contains("/login") || uri.contains("/LoginServlet") || uri.contains("/checkCodeServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/img/")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                request.setAttribute("login_msg", "您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);

            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
