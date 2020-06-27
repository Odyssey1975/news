package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class CarDaoImpl implements CarDao  {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();

    }

    @Override
    public User findubynands(Car car) {

       Query q = sessionFactory.getCurrentSession().createQuery("from User user where user.car.name=:paramName and user.car.series=:paramSeries" );
        q.setParameter("paramName", car.getName());
        q.setParameter("paramSeries", car.getSeries());
        User user1 = (User) q.setMaxResults(1).getSingleResult();
        return user1;
    }
}
