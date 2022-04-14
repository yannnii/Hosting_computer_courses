package ru.computer_courses.servlets.servlet;

import ru.computer_courses.dao.UserListDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUsersServlet", value = "/deleteUser")
public class DeleteUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            UserListDB.delete(id);
            response.sendRedirect(request.getContextPath() + "/usersListServlet");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound_user.jsp").forward(request, response);
        }
    }
}
