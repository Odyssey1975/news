package service;

import dbaccess.UserDAO;
import model.User;

import java.sql.Connection;
import java.util.List;

public class ServiceDuty {

    Connection connection;


    private static ServiceDuty  serviceDuty;

    private ServiceDuty(Connection connection) {
        this.connection = connection;
    }
    public static ServiceDuty getInstance(Connection connection) {
        if (serviceDuty == null) {
            serviceDuty = new ServiceDuty(connection);
        }
        return serviceDuty;
    }
    //Мудреж
    public static ServiceDuty getServiceDuty() {
        return serviceDuty;
    }

    public List<User> getAllusers() {
        return new UserDAO(connection).getAllUsers();
    }
    public void addUser(User user) {
        new UserDAO(connection).createUser(user);
    }
    public void deleteUser(Integer id) {
        new UserDAO(connection).deleteUser(id);
    }


    public void updateUsers(User user) {
        new UserDAO(connection).updateUser(user);
    }
    public void create() {
        new UserDAO(connection).createTable();
    }

    public User findUserAtId(Integer id)
    {
       return new UserDAO(connection).findUserAtId(id);
    }
}
