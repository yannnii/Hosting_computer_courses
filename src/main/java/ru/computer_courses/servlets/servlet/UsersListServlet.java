package ru.computer_courses.servlets.servlet;

import ru.computer_courses.model.UserList;
import ru.computer_courses.dao.UserListDB;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsersListServlet", value = "/usersListServlet")
public class UsersListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<UserList> users = UserListDB.select();
        request.setAttribute("users", users);

        getServletContext().getRequestDispatcher("/admin/users.jsp").forward(request, response);

    }
}
