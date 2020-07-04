package web.controller;


import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ListCars;

import java.util.ArrayList;
import java.util.List;


@Controller
public class Cars {

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam String local, ModelMap model) {
        List<Car> cars;
        cars = new ListCars().getcars();
        String item = findItem(local);
        model.addAttribute("item", item);
        model.addAttribute("listcars", cars);

        return "cars";
    }

    private String findItem(String local) {
        if (local.equals("ru")) {
            return "Машины";
        }
        if (local.equals("en")) {
            return "CAR";
        }
        return "Empty";
    }
}
