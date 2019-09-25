package DAO;

import java.io.*;
import java.util.Properties;

public class UserDAOFactory {
    private static UserDAOFactory instance;
    private Properties properties = new Properties();
    private InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");

    public static synchronized UserDAOFactory getInstance() {
        if (instance == null) {
            instance = new UserDAOFactory();
        }
        return instance;
    }

    public DAOFactory getDAOFactory() throws IOException {
        DAOFactory daoFactory;

        properties.load(inputStream);

        String daoType = properties.getProperty("daoType");
        switch (daoType) {
            case "hibernate":
                daoFactory = new DAOHibernateFactory();
                break;
            case "JDBC":
                daoFactory = new DAOJDBCFactory();
            default:
                daoFactory = new DAOJDBCFactory();
        }
        return daoFactory;
    }
}

