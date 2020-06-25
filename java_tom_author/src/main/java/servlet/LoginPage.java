package servlet;

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

@WebServlet("/login")
public class LoginPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String regform = request.getParameter("reg");
        if (regform.equals("Registration")) {
            response.sendRedirect(request.getContextPath() + "/addUser");
        } else {
            if (regform.equals("Enter")) {
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                request.getSession().setAttribute("password", password);
                request.getSession().setAttribute("login", login);
                HttpSession session = request.getSession();
                User user = UserService.getInstance().finduserbyloginpassword(login, password);
                if (user == null) {
                    response.sendRedirect(request.getContextPath() + "/login");
                } else {
                    response.sendRedirect(request.getContextPath() + "/filter");
                    //String role = (String) session.getAttribute("role");
                    /*switch (role) {
                        case "admin":
                            try {
                                response.sendRedirect(request.getContextPath() + "/admin");
                            } catch ( IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "user":
                            try {
                                response.sendRedirect(request.getContextPath() + "/user");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            try {
                                request.getRequestDispatcher("/login.jsp").forward(request, response);
                            } catch (ServletException | IOException e) {
                                e.printStackTrace();
                            }
                            break;
                    }*/

                }

            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
