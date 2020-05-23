package servlet;

import model.User;
import service.ServiceDuty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/start")
public class MainServ extends HttpServlet {


    private ServiceDuty getServiceJDBC;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = getServiceJDBC.getAllusers();
        if (users == null)
            users = new ArrayList<>();
        request.setAttribute("usersInJDBC", users);
        request.getServletContext().getRequestDispatcher("/jsp/crudUsers.jsp").forward(request, response);
    }


    @Override
    public void init() throws ServletException {
        Connection connection;
        try {
            String dbUrl = "jdbc:mysql://localhost:3306/users";
            String dbUserName = "root";
            String dbPassword = "root";
            String driverClassName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
            getServiceJDBC = ServiceDuty.getInstance(connection);
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException();
        }
        getServiceJDBC.create();
        System.out.println("init JDBC");
    }

}



