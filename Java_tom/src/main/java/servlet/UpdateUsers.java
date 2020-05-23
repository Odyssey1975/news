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
import java.util.ArrayList;
import java.util.List;

public class UpdateUsers {
    Connection connection;

    @WebServlet("/updateUser")
    public class UpdatingUser extends HttpServlet {
        private ServiceDuty serviceJDBC;
        private Integer id;

        @Override
        public void init() throws ServletException {
            serviceJDBC = ServiceDuty.getInstance(connection);
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String idString = req.getParameter("id");
            id = Integer.parseInt(idString);
            User user = serviceJDBC.findUserAtId(id);
            List<User> users = new ArrayList<>();
            users.add(user);
            req.setAttribute("usersInJDBC", users);
            req.getServletContext().getRequestDispatcher("/jsp/update.jsp").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String country = req.getParameter("country");
            User user = new User(id, name, email, country);
            serviceJDBC.updateUsers(user);
            resp.sendRedirect(req.getContextPath() + "/start");
        }
    }

}
