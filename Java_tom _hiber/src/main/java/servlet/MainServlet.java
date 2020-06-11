package servlet;

import model.User;
import service.ServiceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/start")
public class MainServlet extends HttpServlet {
    private ServiceDAO serviceDAO;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(name, email, country);
        serviceDAO.createUsersService(user);
        response.sendRedirect(request.getContextPath() + "/start");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List <User> users = serviceDAO.getAllUsers();
        request.setAttribute("usersInJDBC", users);
        request.getServletContext().getRequestDispatcher("/crud.jsp").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        serviceDAO = ServiceDAO.getServiceDAO();
    }
}




