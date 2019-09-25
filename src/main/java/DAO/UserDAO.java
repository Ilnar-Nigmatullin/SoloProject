package DAO;

import models.User;

import java.util.List;

public interface UserDAO {

    List<User> readUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User getUserByLogin(String user);
}
