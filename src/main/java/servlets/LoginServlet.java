package servlets;

import models.User;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        UserService userService = UserServiceImpl.getInstance();
        User user = userService.getUserByLogin(login);


        if (user.getLogin() != null && user.getPassword().equals(password)) {
            if (user.getRole().equals("user")) {
                session.setAttribute("login", login);
                session.setAttribute("role", user.getRole());
                resp.sendRedirect("/userview/home");

            } else if (user.getRole().equals("admin")) {
                session.setAttribute("login", login);
                session.setAttribute("role", user.getRole());
                resp.sendRedirect("/adminview/users");
            } else {
                resp.sendRedirect("/login");
            }
        }
    }
}

