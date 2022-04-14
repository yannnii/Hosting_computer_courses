package ru.computer_courses.servlets.servlet;

import ru.computer_courses.model.Course;
import ru.computer_courses.dao.CourseDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EnrollCourseServlet", value = "/enrollCourse")
public class EnrollCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("userRole");
        boolean loggedIn = session != null && session.getAttribute("login") != null && session.getAttribute("userRole") != null;
        if (loggedIn ) {
            if (role.equals("teacher")) {
                getServletContext().getRequestDispatcher("/courses.jsp").forward(request, response);
            }
            else if (role.equals("admin")) {
                getServletContext().getRequestDispatcher("/courses.jsp").forward(request, response);
            }
            else if (role.equals("student")) {
                request.setCharacterEncoding("UTF-8");
                String email = (String) session.getAttribute("email");
                String course_name = request.getParameter("course_name");
                String teacher_email = request.getParameter("teacher_email");
                Course course = new Course(course_name, email, teacher_email);
                CourseDB.insert(course);
                getServletContext().getRequestDispatcher("/student/success_student.jsp").forward(request, response);
            }
        }
        else {
            getServletContext().getRequestDispatcher("/auth").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
