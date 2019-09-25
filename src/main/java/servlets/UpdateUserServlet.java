
package servlets;

import models.User;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminview/update")

public class UpdateUserServlet extends HttpServlet {
    private UserService userServiceImpl = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/adminview/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("userName");
        int age = Integer.parseInt(req.getParameter("age"));
        String password = req.getParameter("password");
        String login = req.getParameter("login");
        String role = req.getParameter("role");
        User user = new User(id, name, age, password, login, role);

        userServiceImpl.updateUser(user);
        resp.sendRedirect("/adminview/users");
    }
}

