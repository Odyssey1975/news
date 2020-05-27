package servlet;



import model.User;
import service.ServiceDuty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/deleteUser")
public class DeleteUsers extends HttpServlet {
    private ServiceDuty getServiceDuty;

    @Override
    public void init() throws ServletException {
        getServiceDuty = ServiceDuty.getServiceDuty();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // String[] items = req.getParameterValues("Delete");
        //doPost(req,resp);
        String idString = req.getParameter("id");
        Integer id = Integer.parseInt(idString);
        getServiceDuty.deleteUser(id);
        resp.sendRedirect(req.getContextPath() + "/start");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] items = req.getParameterValues("Delete");
        List<User> users = getServiceDuty.getAllusers();
        if (users == null)
            users = new ArrayList<>();
        for(User user : users)
        {
            for(String str : items)
            {
                if(str.equals(user.getId().toString()))
                {
                    getServiceDuty.deleteUser(user.getId());
                }
            }
        }
        resp.sendRedirect(req.getContextPath() + "/start");
    }
}
