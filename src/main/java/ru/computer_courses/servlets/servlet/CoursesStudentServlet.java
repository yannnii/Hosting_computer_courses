package ru.computer_courses.servlets.servlet;

import ru.computer_courses.model.Course;
import ru.computer_courses.dao.CourseDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CoursesStudentServlet", value = "/coursesStudentServlet")
public class CoursesStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        ArrayList<Course> courses = CourseDB.selectOne(email);
        request.setAttribute("courses", courses);
        if (courses != null) {
            request.setAttribute("courses", courses);
            getServletContext().getRequestDispatcher("/student/courses_student.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
