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

@WebServlet(urlPatterns = {"/adminview/create"})
public class CreateUserServlet extends HttpServlet {

    private UserService userServiceImpl = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/adminview/addUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String login = req.getParameter("login");
        int age = Integer.parseInt(req.getParameter("age"));
        String password = req.getParameter("password");

        User user = new User(userName, login, age, password);
        userServiceImpl.addUser(user);
        resp.sendRedirect("/adminview/users");
    }
}