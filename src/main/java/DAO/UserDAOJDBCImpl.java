package DAO;

import config.DBHelper;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAOJDBCImpl implements UserDAO {
    private Map<String, User> userLogin = new HashMap<>();

    private static UserDAOJDBCImpl instance;
    private DBHelper dbService = DBHelper.getInstance();

    UserDAOJDBCImpl() {
    }

    public static synchronized UserDAOJDBCImpl getInstance() {
        if (instance == null) {
            instance = new UserDAOJDBCImpl();
        }
        return instance;
    }

    public List<User> readUsers() {
        List<User> users = null;
        try {
            String sql = "select * from users";

            users = new ArrayList<>();
            Statement statement = dbService.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUserName(resultSet.getString(2));
                user.setAge(resultSet.getInt(3));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public void updateUser(User user) {
        try {
            String sql = "update users set name = ?, age = ? where id = ?";

            PreparedStatement preparedStatement = dbService.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setInt(3, user.getId());

            int result = preparedStatement.executeUpdate();
            if (result != 0) {
                System.out.println("updated");
            } else {
                System.out.println("not updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addUser(User user) {
        try {
            String sql = "insert into users (name, age) values(?, ?)";

            PreparedStatement preparedStatement = dbService.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setInt(2, user.getAge());


            int result = preparedStatement.executeUpdate();
            if (result != 0) {
                System.out.println("Inserted");
            } else {
                System.out.println("not Inserted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            String sql = "delete from users where id=?";

            PreparedStatement preparedStatement = dbService.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("deleted");
            } else {
                System.out.println("not deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


   @Override
    public User getUserByLogin(String login) {
        String sql = "select * from login where userName=?";
        try {
            PreparedStatement preparedStatement = dbService.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
