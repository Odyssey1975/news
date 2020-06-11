package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.UserJdbcDAO;
import model.User;
import service.ServiceDAO;

import static service.ServiceDAO.getServiceDAO;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {

    private ServiceDAO getServiceDAO;
    private Integer id;

    @Override
    public void init() throws ServletException {
        getServiceDAO = getServiceDAO();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        // Integer id = Integer.parseInt(request.getParameter("id"));
        User user = new User(id, name, email, country);
        getServiceDAO.updateUsersService(user);
        response.sendRedirect(request.getContextPath() + "/start");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        id = Integer.parseInt(idString);
        User user = getServiceDAO.findUsers(id);
        List<User> users = new ArrayList<>();  //поменял
        users.add(user);
        request.setAttribute("usersInJDBC", users);
        request.getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
    }
}
