package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO<T> {
    void createUser(T item) ;
    void updateUser(T model);
    void deleteUser(Integer id);
    List<T> getAllUsers();
    User findUserAtId(Long id);
}
