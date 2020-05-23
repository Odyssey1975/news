package model;

import java.util.List;

public interface CrudInterface<T> {
    void createUser(T item);
    void updateUser(T item);
    void deleteUser(Integer id);
    List<T> getAllUsers();
    User findUserAtId(Integer id);
    void createTable();
}
