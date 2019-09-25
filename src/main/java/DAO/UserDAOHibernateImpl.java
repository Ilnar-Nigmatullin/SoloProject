package DAO;

import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import config.DBHelper;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOHibernateImpl implements UserDAO {
    private static UserDAOHibernateImpl instance;
    private DBHelper dbService = DBHelper.getInstance();

    public UserDAOHibernateImpl() {
    }

    public static UserDAOHibernateImpl getInstance() {
        if (instance == null) {
            instance = new UserDAOHibernateImpl();
        }

        return instance;
    }

    public User getUserByLogin(String login) {
        User user;
        Query query = dbService.getConfiguration().openSession().createQuery("from User where login= :login");
        query.setParameter("login", login);
        user = (User) query.uniqueResult();

        return user;
    }

    @Override
    public List<User> readUsers() {
        List<User> users = (List<User>) dbService.getConfiguration().openSession().createQuery("From User").list();
        return users;
    }

    @Override
    public void addUser(User user) {
        Session session = dbService.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = dbService.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(int id) {
        Session session = dbService.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();

    }
}
