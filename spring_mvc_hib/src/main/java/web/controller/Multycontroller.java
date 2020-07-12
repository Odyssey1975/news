package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.Car;
import web.service.CarService;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
public class Multycontroller {
    @Autowired
    CarService carService;

    /*@GetMapping(value = "listcars")
    public String getChangeCar(ModelMap modelMap) {
        List<Car> cars = carService.findAll();
        modelMap.addAttribute("listcars", cars);
        return "listcars";
    }*/


     /*@PostMapping(value = "add")
    public String addCar(HttpServletRequest req) {
        String series= req.getParameter("series");
        String model = req.getParameter("model");
        String color = req.getParameter("color");
        Car car = new Car().setSeries(series).setModel(model).setColor(color);
        carService.add(car);
       return "redirect:/listcars";
    }*/

     /* @GetMapping(value = "update")
    public String getUpdateUser(HttpServletRequest req, ModelMap model) {
        Long id = Long.parseLong(req.getParameter("id"));
        Car car = carService.findById(id);
        model.addAttribute("listcars", car);
        return "updatecars";
    }*/


     /* @PostMapping (value = "update")
    public String postUpdateUser(HttpServletRequest req) {
        String series = req.getParameter("series");
        String model = req.getParameter("model");
        String color = req.getParameter("color");
        Long id = Long.parseLong(req.getParameter("id"));
        Car car = new Car().setSeries(series).setModel(model).setColor(color).setId(id);
        System.out.println(car);
        carService.update(car);
        System.out.println(car);
        return "redirect:/listcars";
    }*/

    @GetMapping(value = "changeCar")
    public String getChangeCar(ModelMap modelMap) {
        List<Car> cars = carService.findAll();
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
        String[] items = req.getParameterValues("Delete");
//assuming Order is your order class and orderList is your item list
        for (String str : items) {
            try {
                carService.delete(Long.parseLong(str));
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return "redirect:/changeCar";
    }

    @GetMapping(value = "updateUser")
    public String getUpdateUser(HttpServletRequest req, ModelMap model) {
        Long id = Long.parseLong(req.getParameter("id"));
        Car car = carService.findById(id);
        model.addAttribute("Car", car);
        return "change";
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
