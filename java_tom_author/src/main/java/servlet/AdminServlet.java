package servlet;
/*
 *
 *@Data 08.02.2020
 *@autor Fedorov Yuri
 *@project UserAdmin
 *
 */

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private UserService userService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        String role = (String) session.getAttribute("role");
        if (role.equals("user")) {
            resp.sendRedirect(req.getContextPath() + "/filter");
        } else {
            List<User> users = UserService.getInstance().getAll();
            req.setAttribute("usersInJDBC", users);
            req.getServletContext().getRequestDispatcher("/crud.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String country = req.getParameter("country");
        String role = req.getParameter("role");
        User user = new User(login, password, country,role);
        UserService.getInstance().create(user);
        resp.sendRedirect(req.getContextPath() + "/admin");
    }
}
