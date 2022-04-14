package ru.computer_courses.servlets.servlet;

import ru.computer_courses.model.MessageList;
import ru.computer_courses.dao.MessageListDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MessagesOutListServlet", value = "/messagesOutListServlet")
public class MessagesOutListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("userRole");
        ArrayList<MessageList> messages = MessageListDB.selectOneOut(email);
        request.setAttribute("messages", messages);
        if (role.equals("teacher")) {
            request.setAttribute("messages", messages);
            getServletContext().getRequestDispatcher("/teacher/messages_out_teacher.jsp").forward(request, response);
        } else if (role.equals("student")) {
            request.setAttribute("messages", messages);
            getServletContext().getRequestDispatcher("/student/messages_out_student.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("userRole");
        ArrayList<MessageList> messages = MessageListDB.selectOneOut(email);
        request.setAttribute("messages", messages);
        if (role.equals("teacher")) {
            request.setAttribute("messages", messages);
            getServletContext().getRequestDispatcher("/teacher/messages_out_teacher.jsp").forward(request, response);
        } else if (role.equals("student")) {
            request.setAttribute("messages", messages);
            getServletContext().getRequestDispatcher("/student/messages_out_student.jsp").forward(request, response);
        }
    }
}
