
package filtres;

import models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/adminview/*"})
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);

        boolean loggedIn = session != null &&
                session.getAttribute("login") != null &&
                session.getAttribute("role") != null;

        if (loggedIn) {
            String role = session.getAttribute("role").toString();

            if (role.equals("admin")) {
                filterChain.doFilter(req, resp);
            } else if (role.equals("user")) {
                req.getRequestDispatcher("/userview/home").forward(req, resp);
                filterChain.doFilter(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }

        }
    }

    @Override
    public void destroy() {

    }
}
