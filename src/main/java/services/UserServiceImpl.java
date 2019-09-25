package services;

import DAO.UserDAOFactory;
import models.User;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance;

    public static synchronized UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public List<User> readUsers() throws IOException {
        return UserDAOFactory.getInstance().getDAOFactory().createUserDAO().readUsers();
    }

    public void addUser(User user) throws IOException {
        UserDAOFactory.getInstance().getDAOFactory().createUserDAO().addUser(user);
    }

    public void updateUser(User user) throws IOException {
        UserDAOFactory.getInstance().getDAOFactory().createUserDAO().updateUser(user);
    }

    public void deleteUser(int id) throws IOException {
        UserDAOFactory.getInstance().getDAOFactory().createUserDAO().deleteUser(id);
    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        return UserDAOFactory.getInstance().getDAOFactory().createUserDAO().getUserByLogin(login);
    }
}
