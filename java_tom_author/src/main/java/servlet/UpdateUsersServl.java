package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/updateUser")
public class UpdateUsersServl extends HttpServlet {
    private Integer id;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String country = request.getParameter("country");
        String role = request.getParameter("role");
        User user = new User(id, login, password, country,role);
        UserService.getInstance().update(user);

        response.sendRedirect(request.getContextPath() + "/admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        id = Integer.parseInt(idString);
        User user = UserService.getInstance().findUserAtId(id);
        List<User> users = new ArrayList<>();  //поменял
        users.add(user);
        request.setAttribute("usersInJDBC", users);
        request.getServletContext().getRequestDispatcher("/change.jsp").forward(request, response);
    }

}
