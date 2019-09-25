package config;

import org.hibernate.SessionFactory;

import java.sql.Connection;

public class DBHelper {
    private static DBHelper instance;
    private DBServiceJDBC dbServiceJDBC = DBServiceJDBC.getInstance();
    private DBServiceHibernate dbServiceHibernate = DBServiceHibernate.getInstance();


    public static synchronized DBHelper getInstance() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }

    public Connection getConnection() {
        return dbServiceJDBC.getConnection();
    }

    public SessionFactory getConfiguration() {
        return dbServiceHibernate.getSessionFactory();
    }
}
