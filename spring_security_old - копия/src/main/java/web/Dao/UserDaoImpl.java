package web.Dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

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
        entityManager.remove(getUserById(id));
    }

    @Override
    public void update(User user) {
         entityManager.merge(user);
    }
}
