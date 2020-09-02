package web.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;
//_________________________________________________
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User model) {

        entityManager.persist(model);
    }

    @Override

    public List<User> getUsers(){
        return entityManager.createQuery("SELECT u FROM User u").getResultList();

    }

    @Override
    public User getUserById(Long id) {

            return entityManager.find(User.class, id);
    }

    @Override
    public void delete(Long id) {
       /* Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();*/
        entityManager.remove(getUserById(id));
    }

    @Override
    public void update(User user) {
       /* Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();*/
         entityManager.merge(user);
    }
}
