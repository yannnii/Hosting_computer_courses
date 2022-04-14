package ru.computer_courses.servlets.servlet;

import ru.computer_courses.model.UserList;
import ru.computer_courses.dao.UserListDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditUsersServlet", value = "/editUser")
public class EditUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            UserList user = UserListDB.selectOne(id);
            if(user!=null) {
                request.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/admin/edit_user.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound_user.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound_user.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            request.setCharacterEncoding("UTF-8");

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String userRole = request.getParameter("role");
            String city = request.getParameter("city");
            String consent = request.getParameter("consent");
            UserList user = new UserList(id, name, surname, login, password, email, gender, userRole, city, consent);
            UserListDB.update(user);
            response.sendRedirect(request.getContextPath() + "/usersListServlet");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound_user.jsp").forward(request, response);
        }
    }
}
