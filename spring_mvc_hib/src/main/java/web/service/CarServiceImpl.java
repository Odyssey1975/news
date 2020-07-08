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
    public List<Car> findAll() {

        return carDao.listCars();
    }
    @Transactional
    @Override
    public Car findById(Long id) {
        return carDao.findcarbyid(id);
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
