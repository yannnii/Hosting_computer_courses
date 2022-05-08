package ru.computer_courses.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.computer_courses.model.User;

public class AuthDao {

    public void authUser(User user, HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(1 * 60 * 60);
        session.setMaxInactiveInterval(-1);

        String SELECT_USERS_SQL = "SELECT * FROM user WHERE login=(?) AND password=(?);";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://node186572-env-9109343.jelastic.regruhosting.ru/computer_courses?useSSL=false&serverTimezone=UTC", "root", "LCOaam90587");

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_SQL)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());

            ResultSet result = preparedStatement.executeQuery();
            System.out.println(preparedStatement);

            if (result.next()) {
                String id = result.getString("id");
                String name = result.getString("name");
                String surname = result.getString("surname");
                String login = result.getString("login");
                String password = result.getString("password");
                String email = result.getString("email");
                String gender = result.getString("gender");
                String userRole = result.getString("role");
                String city = result.getString("city");
                String consent = result.getString("consent");
                if (userRole.equals("admin")) {
                    session.setAttribute("id", id);
                    session.setAttribute("name", name);
                    session.setAttribute("surname", surname);
                    session.setAttribute("login", login);
                    session.setAttribute("password", password);
                    session.setAttribute("email", email);
                    session.setAttribute("gender", gender);
                    session.setAttribute("userRole", userRole);
                    session.setAttribute("city", city);
                    session.setAttribute("consent", consent);
                    response.sendRedirect("admin/index_admin.jsp");
                }

                else if (userRole.equals("teacher"))
                {
                    session.setAttribute("id", id);
                    session.setAttribute("name", name);
                    session.setAttribute("surname", surname);
                    session.setAttribute("login", login);
                    session.setAttribute("password", password);
                    session.setAttribute("email", email);
                    session.setAttribute("gender", gender);
                    session.setAttribute("userRole", userRole);
                    session.setAttribute("city", city);
                    session.setAttribute("consent", consent);
                    response.sendRedirect("teacher/index_teacher.jsp");
                    }
                else if (userRole.equals("student"))
                {
                    session.setAttribute("id", id);
                    session.setAttribute("name", name);
                    session.setAttribute("surname", surname);
                    session.setAttribute("login", login);
                    session.setAttribute("password", password);
                    session.setAttribute("email", email);
                    session.setAttribute("gender", gender);
                    session.setAttribute("userRole", userRole);
                    session.setAttribute("city", city);
                    session.setAttribute("consent", consent);
                    response.sendRedirect("student/index_student.jsp");
                    }
                else if (userRole.equals(""))
                    {
                        response.sendRedirect("success_teacher.jsp");
                    }
                else
                    {
                        response.sendRedirect("error.jsp");
                    }
                }
            else
                {
                    response.sendRedirect("error.jsp");
                }

            }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
