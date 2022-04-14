package ru.computer_courses.servlets.servlet;

import ru.computer_courses.model.MessageList;
import ru.computer_courses.dao.MessageListDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AnswerMessageServlet", value = "/answerMessageServlet")
public class AnswerMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = request.getParameter("from");
        request.setAttribute("from", from);

            HttpSession session = request.getSession();
            String role = (String) session.getAttribute("userRole");
            if (role.equals("teacher"))
            {
                getServletContext().getRequestDispatcher("/teacher/answer_message_teacher.jsp").forward(request, response);
            }
            else if (role.equals("student"))
            {
                getServletContext().getRequestDispatcher("/student/answer_message_student.jsp").forward(request, response);
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String from = (String) session.getAttribute("email");
        String whom = request.getParameter("from");
        String text_mes = request.getParameter("text_mes");
        request.setCharacterEncoding("UTF-8");
        MessageList message = new MessageList(from, whom, text_mes);
        MessageListDB.answerMessage(message);
        getServletContext().getRequestDispatcher("/messagesOutListServlet").forward(request, response);
    }
}
