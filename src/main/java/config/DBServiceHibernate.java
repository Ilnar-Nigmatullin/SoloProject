package config;

import models.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class DBServiceHibernate {
    private static DBServiceHibernate instance;
    private static SessionFactory sessionFactory;

    public static DBServiceHibernate getInstance() {
        if (instance == null) {
            instance = new DBServiceHibernate();
        }
        return instance;
    }

    public SessionFactory getSessionFactory() throws HibernateException {
        try {
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url",
                    "jdbc:mysql://localhost:3306/db_crud?useUnicode=true&characterEncoding=utf8");
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "1234");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.addAnnotatedClass(User.class);

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());

            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}