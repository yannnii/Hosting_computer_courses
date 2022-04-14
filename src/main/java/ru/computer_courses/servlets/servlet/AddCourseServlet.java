package ru.computer_courses.servlets.servlet;

import ru.computer_courses.model.CourseList;
import ru.computer_courses.dao.CourseListDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCourseServlet", value = "/addCourse")
public class AddCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/admin/add_course.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            String name = request.getParameter("name");
            String short_desc = request.getParameter("short_desc");
            String description = request.getParameter("description");
            String teacher = request.getParameter("teacher");
            CourseList course = new CourseList(name, short_desc, description, teacher);
            CourseListDB.insert(course);
            response.sendRedirect(request.getContextPath()+"/coursesListServlet");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/admin/add_course.jsp").forward(request, response);
        }
    }
}
