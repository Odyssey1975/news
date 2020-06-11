package servlet;



import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteUsers")
public class DeleteUsersServl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] items = request.getParameterValues("Delete");
        for (String str : items) {
            try {
                UserService.getInstance().delete(Integer.parseInt(str));
            } catch (Throwable e) {
                e.printStackTrace();
            }


        }

        response.sendRedirect(request.getContextPath() + "/start");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = UserService.getInstance().getAll();
        request.setAttribute("usersInJDBC", users);
        request.getServletContext().getRequestDispatcher("/crud.jsp").forward(request, response);
    }
}
