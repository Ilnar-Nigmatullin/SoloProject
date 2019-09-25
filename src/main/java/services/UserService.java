package services;

import models.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<User> readUsers() throws IOException;

    void addUser(User user) throws IOException;

    void updateUser(User user) throws IOException;

    void deleteUser(int id) throws IOException;

    User getUserByLogin(String login) throws IOException;
}
