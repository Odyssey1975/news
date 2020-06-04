package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface ServiceDAO <T> {
    void create(T user) throws SQLException;
    void update(T user);
    void delete(Integer id);
    List<T> getAll();
    T findUserAtId(Integer id);
}
