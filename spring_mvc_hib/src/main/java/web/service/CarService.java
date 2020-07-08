package web.service;

import web.model.Car;

import java.util.List;

public interface CarService  {
    void add(Car model);
    List<Car> findAll();
    Car findById(Long id);
    void delete(Long id);
    void update (Car model);

}
