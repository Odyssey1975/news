package dao;


import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserJdbcDAO implements UserDAO <User>{
   private Connection connection;

   public UserJdbcDAO (Connection connection)
   {this.connection=connection;

   }



    @Override
    public void createUser(User user) {
       
    }

    @Override
    public void updateUser(User model) {
    }

    @Override
    public void deleteUser(Integer id) {
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User findUserAtId(Long id) {
        return null;
    }
}
