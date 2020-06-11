package dao;

import model.User;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import javax.jws.soap.SOAPBinding;
import javax.persistence.Query;
import javax.persistence.criteria.From;
import java.sql.SQLException;
import java.util.List;

public class UserHibernateDAO implements UserDAO<User> {

    private SessionFactory sessionFactory;
    private static UserHibernateDAO userDaoHiberbate;

    public UserHibernateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /* public UserHibernateDAO() {

         this.sessionFactory = DBHelper.getsessionfactory() ;
     }*/
    public static UserHibernateDAO getInstance(SessionFactory sessionFactory) {
        if (userDaoHiberbate == null) {
            userDaoHiberbate = new UserHibernateDAO(sessionFactory);
        }
        return userDaoHiberbate;
    }


    @Override
    public void createUser(User user) {
        //Session session =DBHelper.getsessionfactory().openSession();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
       // User user1= new User();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
       /* user.getId();
        user.getName();
        user.getEmail();
        user.getCountry();*/

        session.update(user);
        transaction.commit();

    }

    @Override
    // тут могут быть вопросы
    public void deleteUser(Integer id) {
        User userid;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        userid= session.load(User.class,id);
        session.delete(userid);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        return session.createQuery("From User", User.class).list();
    }

    @Override
    public User findUserAtId(Integer id) {
        Session session = sessionFactory.openSession();
        return session.byId(User.class).load(id);
    }
}