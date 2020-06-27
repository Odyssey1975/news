package hiber;

import hiber.model.Car;
import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);
      //  userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      //  userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      //  userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      //  userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


        User user5 = new User("User5", "Lastname5", "user5@mail.ru");
        userService.add(user5);
        Car car5 = new Car("Kia Rio", 5);
        carService.add(car5);
        user5.setCar(car5);
        userService.update(user5);

        User user6 = new User("User6", "Lastname6", "user6@mail.ru");
        userService.add(user6);
        Car car6 = new Car("Kia Cerato", 6);
        carService.add(car6);
        user6.setCar(car6);
        userService.update(user6);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().getName());
        }

        String name = "Kia Rio";
        int series = 5;
        Car car1 = new Car().setName(name).setSeries(series);
        User user = carService.finduserbynameandseries(car1);
        System.out.println(user.getFirstName()+ " " + user.getLastName() + " by Car's name and series");
        context.close();
    }
}
