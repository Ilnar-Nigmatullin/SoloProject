package DAO;

public class DAOHibernateFactory implements DAOFactory {
    @Override
    public UserDAO createUserDAO() {
        return new UserDAOHibernateImpl();
    }
}
