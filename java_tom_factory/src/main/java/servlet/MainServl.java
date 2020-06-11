package servlet;


import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/start")
public class MainServl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        UserService.getInstance().create(user);
        response.sendRedirect(request.getContextPath() + "/start");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //UserService userService = new UserService();
        List<User> users = UserService.getInstance().getAll();
        request.setAttribute("usersInJDBC", users);
        request.getServletContext().getRequestDispatcher("/crud.jsp").forward(request, response);
    }
}
