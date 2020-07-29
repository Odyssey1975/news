package web.Dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getUsers();

    User getUserById(Long id);

    void delete(Long id);

    void update(User user);
}
