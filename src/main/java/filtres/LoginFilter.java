package filtres;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);

        String loginURI = req.getContextPath() + "/login";
        boolean loggedIn = session != null &&
                session.getAttribute("login") != null &&
                session.getAttribute("role") != null;
        boolean loginReq = req.getRequestURI().equals(loginURI);

        if (loggedIn || loginReq) {
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {

    }
}
