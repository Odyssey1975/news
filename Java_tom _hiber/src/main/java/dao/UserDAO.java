package dao;

import model.User;

import java.util.List;

public interface UserDAO <T> {
    void createUser(T item);
    void updateUser(T model);
    void deleteUser(Integer id);
    List<T> getAllUsers();
    User findUserAtId(Integer id);
}
