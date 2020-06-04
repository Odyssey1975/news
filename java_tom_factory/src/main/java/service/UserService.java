package service;

import dao.UserDAO;
import dao.UserHibernateDAO;
import factory.FactoryMakingConnectors;

import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.sql.SQLException;
import java.util.List;



public class UserService {


    private static UserService instance;

    private static UserDAO dao;

    private UserService(FactoryMakingConnectors factory) {
        dao = factory.getUserDao();
    }

    public static UserService getInstance()  // к сервлетам
    {
        if (instance==null) {
           instance= new UserService(FactoryMakingConnectors.getFactoryDAO());
        }
        return instance;
    }


    public void create(User user) throws SQLException {
        dao.createUser(user);
    }


    public void update(User user) {
        dao.updateUser(user);

    }


    public void delete(Integer id) {
        dao.deleteUser(id);
    }


    public static List<User> getAll() {

        return  dao.getAllUsers();
    }


    public User findUserAtId(Long id) {
        return dao.findUserAtId(id);
    }
}
