package DAO;

public class DAOJDBCFactory implements DAOFactory {

    @Override
    public UserDAO createUserDAO() {
        return new UserDAOJDBCImpl();
    }
}
