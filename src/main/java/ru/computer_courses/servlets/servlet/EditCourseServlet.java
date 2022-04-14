package ru.computer_courses.servlets.servlet;

import ru.computer_courses.model.CourseList;
import ru.computer_courses.dao.CourseListDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditCourseServlet", value = "/editCourse")
public class EditCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            CourseList course = CourseListDB.selectOne(id);
            if(course!=null) {
                request.setAttribute("course", course);
                HttpSession session = request.getSession();
                String role = (String) session.getAttribute("userRole");
                if (role.equals("admin"))
                {
                    getServletContext().getRequestDispatcher("/admin/edit_course.jsp").forward(request, response);
                }
                else if (role.equals("teacher"))
                {
                    getServletContext().getRequestDispatcher("/teacher/edit_course_teacher.jsp").forward(request, response);
                }
            }
            else {
                getServletContext().getRequestDispatcher("/notfound_course.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound_course.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            request.setCharacterEncoding("UTF-8");

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String short_desc = request.getParameter("short_desc");
            String description = request.getParameter("description");
            String teacher = request.getParameter("teacher");

            CourseList course = new CourseList(id, name, short_desc, description, teacher);
            CourseListDB.update(course);
            request.setAttribute("course", course);
            HttpSession session = request.getSession();
            String role = (String) session.getAttribute("userRole");
            if (role.equals("admin"))
            {
                response.sendRedirect(request.getContextPath() + "/coursesListServlet");
            }
            else if (role.equals("teacher"))
            {
                response.sendRedirect(request.getContextPath() + "/coursesListTeacherServlet");
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound_course.jsp").forward(request, response);
        }
    }
}
