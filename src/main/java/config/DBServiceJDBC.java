package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBServiceJDBC {
    private static DBServiceJDBC instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/db_crud?useUnicode=true&characterEncoding=utf8";
    private String username = "root";
    private String password = "1234";

    public static synchronized DBServiceJDBC getInstance() {
        if (instance == null) {
            instance = new DBServiceJDBC();
        }
        return instance;
    }

    private DBServiceJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
