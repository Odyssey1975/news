package hiber.service;

import hiber.dao.CarDaoImpl;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDaoImpl carDao;

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars() {
        return carDao.listCars();
    }

    @Transactional(readOnly = true)
    @Override
    public User finduserbynameandseries( Car car) {

        User user = carDao.findubynands(car);
        return user;
    }
}
