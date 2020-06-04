package dao;

import model.User;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.From;
import java.sql.SQLException;
import java.util.List;

public class UserHibernateDAO implements UserDAO<User> {
    private SessionFactory sessionFactory;


    public UserHibernateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    } // добавил конструктор

    @Override
    public void createUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();

    }

    @Override
    public void updateUser(User user) {
        Session session =sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();

    }

    @Override
    // тут могут быть вопросы
    public void deleteUser(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(id);
        transaction.commit();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        return session.createQuery("From User",User.class ).list();
    }

    @Override
    public User findUserAtId(Long id) {
        Session session =sessionFactory.openSession();
        return session.byId(User.class).load(id);
    }
}