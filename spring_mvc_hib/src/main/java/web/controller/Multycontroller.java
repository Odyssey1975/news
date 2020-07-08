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
public class Multycontroller {
    @Autowired
    CarService carService;

    @GetMapping("/listcars")
    public String getChangeCar(ModelMap modelMap) {
        List<Car> cars = carService.findAll();
        modelMap.addAttribute("listcars", cars);
        return "listcars";
    }




    @PostMapping("/addcar")
    public String addCar(HttpServletRequest req) {
        String series= req.getParameter("series");
        String model = req.getParameter("model");
        String color = req.getParameter("color");
        Car car = new Car().setSeries(series).setModel(model).setColor(color);
        carService.add(car);
        return "redirect:/listcars";
    }



}
