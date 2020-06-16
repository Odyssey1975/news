package servlet;

import model.User;
import service.UserService;

import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@WebFilter("/filter")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        Integer id;
        //  chain.doFilter(request, response);
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final HttpSession session = req.getSession();
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {
            final String role = (String) session.getAttribute("role");
            moveToMenu(req, res, role);

        }
        //===================
        else {
            res.sendRedirect(req.getContextPath() + "/login");
            //=============
        }
    }

    private void moveToMenu(HttpServletRequest req, HttpServletResponse res, String role) {
        switch (role) {
            case "admin":
                try {
                    req.getRequestDispatcher("/crud.jsp").forward(req, res);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case "user":
                try {
                    req.getRequestDispatcher("/user.jsp").forward(req, res);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    req.getRequestDispatcher("/login.jsp").forward(req, res);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
