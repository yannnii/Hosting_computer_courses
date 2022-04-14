package ru.computer_courses.servlets.servlet;

import ru.computer_courses.model.MessageList;
import ru.computer_courses.dao.MessageListDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MessagesInListServlet", value = "/messagesInListServlet")
public class MessagesInListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("userRole");
        ArrayList<MessageList> messages = MessageListDB.selectOneIn(email);
        request.setAttribute("messages", messages);
        if (messages != null) {
            if (role.equals("teacher")) {
                request.setAttribute("messages", messages);
                getServletContext().getRequestDispatcher("/teacher/messages_in_teacher.jsp").forward(request, response);
            } else if (role.equals("student")) {
                request.setAttribute("messages", messages);
                getServletContext().getRequestDispatcher("/student/messages_in_student.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
