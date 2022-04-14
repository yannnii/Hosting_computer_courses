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

@WebServlet(name = "CoursesListServlet", value = "/coursesListServlet")
public class CoursesListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<CourseList> courses = CourseListDB.select();
        request.setAttribute("courses", courses);
        getServletContext().getRequestDispatcher("/admin/courses_admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
