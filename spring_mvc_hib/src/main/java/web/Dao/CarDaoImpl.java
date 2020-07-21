package web.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car model) {
        sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public List<Car> getCars() {
        return sessionFactory.getCurrentSession().createQuery("from Car")
                .getResultList();
    }

    @Override
    public Car getCarById(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(Car.class, id);
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Car car = session.get(Car.class, id);
        session.delete(car);
        session.getTransaction().commit();
    }

    @Override
    public void update(Car car) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(car);
        session.getTransaction().commit();
    }
}
