package ru.computer_courses.servlets.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import ru.computer_courses.dao.AuthDao;
import ru.computer_courses.model.User;

@WebServlet(name = "AuthServlet", value = "/auth")
public class AuthServlet extends HttpServlet {

    private AuthDao authDao = new AuthDao();

    public AuthServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean loggedIn = session != null && session.getAttribute("login") != null && session.getAttribute("userRole") != null;
        if (loggedIn)
        {
            String userRole = session.getAttribute("userRole").toString();
            if (userRole.equals("admin"))
            {
                response.sendRedirect("admin/index_admin.jsp");
            }
            else if (userRole.equals("teacher"))
            {
                response.sendRedirect("teacher/index_teacher.jsp");
            }
            else if (userRole.equals("student"))
            {
                response.sendRedirect("student/index_student.jsp");
            }
        }
        else
        {
            response.sendRedirect("auth.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        try
        {
            authDao.authUser(user, request, response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }

    }
}
