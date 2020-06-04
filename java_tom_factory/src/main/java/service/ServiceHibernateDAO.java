package service;

import dao.UserDAO;
import dao.UserHibernateDAO;
import factory.FactoryMakingConnectors;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;
import java.util.List;



public class ServiceHibernateDAO implements ServiceDAO <User>{
    private static SessionFactory sessionFactory;
 private     static ServiceHibernateDAO serviceHibernateDAO;
 private     static UserHibernateDAO userHibernateDAO;

    private static ServiceHibernateDAO instance;

    private UserDAO dao;

    private ServiceHibernateDAO(FactoryMakingConnectors factory) {
        dao = factory.getUserDao();
    }


    @Override
    public void create(User user) {
         userHibernateDAO.createUser(user); ;
    }

    @Override
    public void update(User model) {
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findUserAtId(Integer id) {
        return null;
    }
}
