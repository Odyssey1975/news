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
import java.util.List;


@WebServlet("/addUser")
public class CreateUsers extends HttpServlet {
    private ServiceDuty serviceDutyJDBC;
    Connection connection;

    @Override
    public void init() throws ServletException {
        serviceDutyJDBC = ServiceDuty.getInstance(connection);
        //serviceDutyJDBC = ServiceDuty.getServiceDuty();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = serviceDutyJDBC.getAllusers();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(name, email, country);
        serviceDutyJDBC.addUser(user);
        resp.sendRedirect(req.getContextPath() + "/start");
    }
}


