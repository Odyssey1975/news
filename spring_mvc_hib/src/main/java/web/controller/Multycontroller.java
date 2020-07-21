package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Car;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MultyController {
    @Autowired
    private CarService carService;

    @GetMapping(value = "changeCar")
    public String getChangeCar(ModelMap modelMap) {
        List<Car> cars = carService.getCars();
        modelMap.addAttribute("carsInJDBC", cars);
        return "crud";
    }

    @PostMapping(value = "addCar")
    public String addCar(HttpServletRequest req) {
        String series = req.getParameter("series");
        String model = req.getParameter("model");
        String color = req.getParameter("color");
        Car car = new Car().setSeries(series).setModel(model).setColor(color);
        carService.add(car);
        return "redirect:/changeCar";
    }

    @PostMapping(value = "deleteCar")
    public String deleteCar(HttpServletRequest req) {
        String item = req.getParameter("Delete");
        carService.delete(Long.parseLong(item));
        return "redirect:/changeCar";
    }

    @GetMapping(value = "updateUser")
    public String getUpdateUser(HttpServletRequest req, ModelMap model) {
        Long id = Long.parseLong(req.getParameter("id"));
        Car car = carService.getCarById(id);
        model.addAttribute("Car", car);
        return "update";
    }

    @PostMapping(value = "updateUser")
    public String postUpdateUser(HttpServletRequest req) {
        String series = req.getParameter("series");
        String model = req.getParameter("model");
        String color = req.getParameter("color");
        Long id = Long.parseLong(req.getParameter("id"));
        Car car = new Car().setSeries(series).setModel(model).setColor(color).setId(id);
        carService.update(car);
        return "redirect:/changeCar";
    }
}
