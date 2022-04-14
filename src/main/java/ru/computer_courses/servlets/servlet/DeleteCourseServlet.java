package ru.computer_courses.servlets.servlet;

import ru.computer_courses.dao.CourseListDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCourseServlet", value = "/deleteCourse")
public class DeleteCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            CourseListDB.delete(id);
            response.sendRedirect(request.getContextPath() + "/coursesListServlet");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound_courses.jsp").forward(request, response);
        }
    }
}
