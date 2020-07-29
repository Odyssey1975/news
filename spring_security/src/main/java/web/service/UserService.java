package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    void add(User model);

    List<User> getUsers();

    User getUserById(Long id);

    void delete(Long id);

    void update(User model);
}
