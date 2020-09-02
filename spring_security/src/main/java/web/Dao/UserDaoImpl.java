package web.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User model) {

        sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User")
                .getResultList();
    }

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(User.class, id);
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }
}
