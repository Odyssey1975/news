package service;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class ListCars {
    public List<Car> getcars() {
        List<Car> listcars = new ArrayList<>();
       /* listcars.add("BMW");
        listcars.add("Alfa-Romeo");
        listcars.add("Audi");*/
        // Car car =new Car();
        listcars.add(new Car().setModel("BMW").setSeries("6").setColor("red"));
        listcars.add(new Car().setModel("Alfa-Romeo").setSeries("2").setColor("yellow"));
        listcars.add(new Car().setModel("Audi").setSeries("4").setColor("green"));
/*
        String[] mod = {"BMW", "Alfa-Romeo", "Audi"};
        String[] ser = {"1", "2", "3"};
        String[] color = {"red", "green", "yellow"};
        String[] cars = {"BMW,1,red"};*/
        return listcars;
    }
}
