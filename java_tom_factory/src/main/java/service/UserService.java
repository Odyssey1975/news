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

    private  UserDAO dao;

    private UserService() { //был public
       dao = FactoryMakingConnectors.getUserDAO();
        //dao= new UserHibernateDAO();
    }

    public static UserService getInstance()  // к сервлетам
    {
        if (instance==null) {
           instance= new UserService();
        }
        return instance;
    }


    public void create(User user) {
        dao.createUser(user);
    }


    public void update(User user) {
        dao.updateUser(user);

    }


    public void delete(Integer id) {
        dao.deleteUser(id);
    }


    public  List<User> getAll() {

        return  dao.getAllUsers();
    }


    public User findUserAtId(Integer id) {
        return dao.findUserAtId(id);
    }
}
