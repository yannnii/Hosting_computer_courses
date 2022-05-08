package ru.computer_courses.dao;

import ru.computer_courses.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

public class RegistrationDao {

    public void registrationUser(User user, HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {

        String INSERT_USERS_SQL = "INSERT INTO user (name, surname, login, password, email, gender, role, city, consent) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        //request.setCharacterEncoding("UTF-8");
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://node186572-env-9109343.jelastic.regruhosting.ru/computer_courses?useSSL=false&serverTimezone=UTC", "root", "LCOaam90587");

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setString(7, user.getUserRole());
            preparedStatement.setString(8, user.getCity());
            preparedStatement.setString(9, user.getConsent());
            System.out.println(preparedStatement);

            int result = preparedStatement.executeUpdate();

            if (result != 0)
            {
                Cookie username = new Cookie("login", request.getParameter("login"));
                response.addCookie(username);
                System.out.println(user.getUserRole());
                if (user.getUserRole().equals(""))
                {
                    response.sendRedirect("success_teacher.jsp");
                }
                else if (user.getUserRole().equals("student"))
                {
                    response.sendRedirect("success.jsp");
                }
            }
            else
            {
                response.sendRedirect("error.jsp");
            }

        }
        catch (SQLException e) {
            printSQLException(e, response);
        }
    }

    private void printSQLException(SQLException ex, HttpServletResponse response) throws IOException {
        for (Throwable e: ex)
        {
            if (e instanceof SQLException)
            {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null)
                {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
        response.sendRedirect("error.jsp");
    }
}
