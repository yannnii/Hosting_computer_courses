package ru.computer_courses.servlets.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/student/*")
public class StudentFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("login") != null && session.getAttribute("userRole") != null;
        if (loggedIn)
        {
            String userRole = session.getAttribute("userRole").toString();
            if (userRole.equals("student"))
            {
                filterChain.doFilter(request, response);
            }
            else if (userRole.equals("admin"))
            {
                response.sendRedirect("../admin/index_admin.jsp");
            }
            else if (userRole.equals("teacher"))
            {
                response.sendRedirect("../teacher/index_teacher.jsp");
            }
        }
        else
        {
            response.sendRedirect("../index.jsp");
        }
    }

    @Override
    public void destroy() {
    }

}
