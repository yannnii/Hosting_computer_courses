package ru.computer_courses.servlets.servlet;

import ru.computer_courses.dao.CourseListDB;
import ru.computer_courses.model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

@WebServlet(name = "FindCoursesServlet", value = "/findCoursesServlet")
public class FindCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String usersearch = request.getParameter("usersearch").trim();
        String usersearch1 = "%" + usersearch + "%";
        String usersearch2 = "%" + usersearch.toLowerCase(Locale.ROOT) + "%";
        ArrayList<CourseList> courses = CourseListDB.userSearch(usersearch1, usersearch2);
        request.setAttribute("courses", courses);
        if (courses != null) {
            request.setAttribute("courses", courses);
            getServletContext().getRequestDispatcher("/user_search.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/notfound_course.jsp").forward(request, response);
        }
    }
}
