package service;

import dao.UserJdbcDAO;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import static util.DBHelper.getSessionFactory;

public class ServiceDAO {
    private static ServiceDAO serviceDAO;
    private SessionFactory sessionFactory;

    private ServiceDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static ServiceDAO getServiceDAO() {
        if (serviceDAO == null) {
            serviceDAO = new ServiceDAO(getSessionFactory());
        }
        return serviceDAO;
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> users = new UserJdbcDAO(session).getAllUsers();
        session.close();
        return users;
    }

    public void deleteUsersService(Integer id) {
        Session session = sessionFactory.openSession();
        new UserJdbcDAO(session).deleteUser(id);
        session.close();

    }

    public void createUsersService(User user) {
        Session session = sessionFactory.openSession();
        new UserJdbcDAO(session).createUser(user);
        session.close();
    }

    public void updateUsersService(User user) {
        Session session = sessionFactory.openSession();
        new UserJdbcDAO(session).updateUser(user);
        session.close();

    }

    public User findUsers(Integer id) {
        Session session = sessionFactory.openSession();
        User user = new UserJdbcDAO(session).findUserAtId(id);
        session.close();
        return user;
    }


}
