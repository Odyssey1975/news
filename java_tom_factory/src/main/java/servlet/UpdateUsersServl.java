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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        // Integer id = Integer.parseInt(request.getParameter("id"));
        User user = new User(id, name, email, country);
        UserService.getInstance().update(user);
        response.sendRedirect(request.getContextPath() + "/start");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        id = Integer.parseInt(idString);
        User user = UserService.getInstance().findUserAtId(id);
        List<User> users = new ArrayList<>();  //поменял
        users.add(user);
        request.setAttribute("usersInJDBC", users);
        request.getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
    }

}
