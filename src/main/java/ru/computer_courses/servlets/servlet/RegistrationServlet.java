package ru.computer_courses.servlets.servlet;

import ru.computer_courses.dao.AuthDao;
import ru.computer_courses.dao.RegistrationDao;
import ru.computer_courses.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import ru.computer_courses.model.User;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {

    private RegistrationDao registrationDao = new RegistrationDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("registration.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String userRole = request.getParameter("userRole");
        if (userRole.equals("teacher")){
            userRole = "";
        }
        String city = request.getParameter("city");
        String consent = request.getParameter("consent");
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setUserRole(userRole);
        user.setCity(city);
        user.setConsent(consent);
        try
        {
            registrationDao.registrationUser(user, request, response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
