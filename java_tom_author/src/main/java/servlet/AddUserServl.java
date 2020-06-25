package servlet;


import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addUser")
public class AddUserServl extends HttpServlet {
    private UserService userService;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/addUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        String country=req.getParameter("country");
        String role=req.getParameter("role");
        req.getSession().setAttribute("role", role);
        User user=new User(login,password,country,role);
       try{
           UserService.getInstance().create(user);
       }catch(Throwable throwable){
           throw new IllegalArgumentException();
       }

       //=========Сохраняем сессию=================================



        //=========================================
        resp.getWriter().write("Adding is succsessfull");
     //   resp.sendRedirect(req.getContextPath() + "/login");

    }

}
