package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Dao.CarDao;
import web.model.Car;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarDao carDao;

    @Transactional
    @Override
    public void add(Car model) {
        carDao.add(model);
    }

    @Transactional
    @Override
    public List<Car> getCars() {
        return carDao.getCars();
    }

    @Transactional
    @Override
    public Car getCarById(Long id) {
        return carDao.getCarById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        carDao.delete(id);
    }

    @Transactional
    @Override
    public void update(Car model) {
        carDao.update(model);
    }
}
