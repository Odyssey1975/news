package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
public class UserJdbcDAO implements UserDAO <User> {
    private Session session;
    private final String HQL_UPDATE = "update User set name=:name ,email=:email, country=:country where id = :id ";
    public UserJdbcDAO(Session session) {
        this.session = session;
    }
    @Override
    public void createUser(User model) {
        Transaction transaction = session.beginTransaction();
        session.save(model);
        transaction.commit();
    }
    @Override
    public void updateUser(User model) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(HQL_UPDATE);
        query.setParameter("id", model.getId());
        query.setParameter("name", model.getName());
        query.setParameter("email", model.getEmail());
        query.setParameter("country", model.getCountry());
        query.executeUpdate();
        transaction.commit();
    }
    @Override
    public void deleteUser(Integer id) {
        String hql = "DELETE User WHERE id = :id";
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
    }
    @Override
    public List<User>  getAllUsers() {
        Query query = session.createQuery("FROM User");
        List<User> users = query.list();
        return  users;

    }
    @Override
    public User findUserAtId(Integer id) {
        Query query = session.createQuery("from User where id = '" + id + "' ");
        return (User) query.getSingleResult();
    }
}
