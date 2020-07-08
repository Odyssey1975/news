package web.Dao;



import web.model.Car;


import java.util.List;

public interface CarDao {
    void add(Car car);
    List<Car> listCars();
    Car findcarbyid(Long id);
    void delete(Long id);
    void update(Car car);

}
