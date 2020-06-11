package servlet;

import model.User;
import service.ServiceDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import service.ServiceDAO;
import static service.ServiceDAO.getServiceDAO;

@WebServlet("/deleteUser")
public class Delete extends HttpServlet {
    ServiceDAO getServiceDAO;

    @Override
    public void init() throws ServletException {
      getServiceDAO =getServiceDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String [] massivvalues = request.getParameterValues("Delete");
        List<User> list = getServiceDAO.getAllUsers();

        if (list == null){
            getServiceDAO.getAllUsers();
        }

        for (User user: list) {
            for (String string : massivvalues) {
                if (string.equals(user.getId().toString()))
                {
                    getServiceDAO.deleteUsersService(user.getId());

                }
            }

        }
        response.sendRedirect(request.getContextPath() + "/start");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }


}
