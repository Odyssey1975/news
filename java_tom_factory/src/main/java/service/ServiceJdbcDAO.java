package service;

import dao.UserJdbcDAO;
import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static util.DBHelper.getConnection;

public class ServiceJdbcDAO implements ServiceDAO <User> {
    private   Connection connection;
   private static ServiceJdbcDAO serviceJdbcDAO;

    private ServiceJdbcDAO(Connection connection) {
        this.connection = connection;
    }

    public static ServiceJdbcDAO getInstance() {
        if (serviceJdbcDAO == null)
        {
            serviceJdbcDAO= new ServiceJdbcDAO(getConnection());
        }
        System.out.println("init JDBC");
        return serviceJdbcDAO;
    }


    @Override
    public void create(User user) throws SQLException {
        new UserJdbcDAO(connection).createUser(user);
    }

    @Override
    public void update(User user) {
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findUserAtId(Integer id) {
        return null;
    }
}





