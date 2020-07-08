package web.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.model.Car;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao
{
@Autowired
private SessionFactory sessionFactory ;

    @Override
    public void add(Car model) {
        sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public List<Car> listCars() {
        TypedQuery<Car> query1 = sessionFactory.getCurrentSession().createQuery("from Car");
        return query1.getResultList();

    }

    @Override
    public Car findcarbyid(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Car car) {

    }
}
