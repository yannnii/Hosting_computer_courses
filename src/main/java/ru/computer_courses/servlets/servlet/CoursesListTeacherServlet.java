package ru.computer_courses.servlets.servlet;

import ru.computer_courses.model.CourseList;
import ru.computer_courses.dao.CourseListDB;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CoursesListTeacherServlet", value = "/coursesListTeacherServlet")
public class CoursesListTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String teacher = (String) session.getAttribute("email");
        ArrayList<CourseList> courses = CourseListDB.selectTeacher(teacher);
        request.setAttribute("courses", courses);
            if (courses != null) {
                request.setAttribute("courses", courses);
                getServletContext().getRequestDispatcher("/teacher/courses_teacher.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/teacher/notfound_course.jsp").forward(request, response);
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
