<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String login = (String) session.getAttribute("login");
%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <title>Входящие сообщения</title>
    <link rel="stylesheet" href="resources/style.css">
    <link type="image/x-icon" href="resources/img/logo.png" rel="shortcut icon">
</head>
<body>
<div class="content">
    <div class="header">
        <div class="header1">
            <div class="header1_cont1">
                <div class="header1_cont11">
                    <img src="resources/img/logo.png" alt="logo" width="130px" height="130px">
                </div>
                <div class="header1_cont12">.TECH</div>
                <div class="header1_cont13">компьютерная школа</div>
            </div>
            <div class="header1_cont2">
                <div class="header1_cont21">Дополнительное образование</div>
                <div class="header1_cont22">Ждем вас: +7 (123) 456-78-90</div>
            </div>
        </div>
        <div class="header2">
            <div class="header2_cont1">
                ШКОЛА КОМПЬЮТЕРНЫХ ИСКУССТВ
            </div>
            <div class="header2_cont2">
                приступите к знакомству с огромным миром информационных технологий и откройте для себя совершенно новые горизонты
            </div>
        </div>
        <div class="header3">
            <form name="search" method="post" action="findCoursesServlet">
                <input id="search" name="usersearch" placeholder="Поиск по курсам" type="text" required>
                <input type="submit" value="Поиск" style="height: 32px; width: 80px; padding: 0; border-radius: 3px; font-size: 16px; margin-right: 10px; border: 1px solid #CCCCFF"/>
            </form>
        </div>
    </div>
    <div class="menu">
        <button><a href="<%= request.getContextPath() %>/index.jsp">Главная</a></button>
        <button class="dropdown">
            <a href="<%= request.getContextPath() %>/courses.jsp">Направления обучения</a>
            <div class="menu_dropdown">
                <a href="<%= request.getContextPath() %>/courses/android.jsp">Разработка приложений на Android</a>
                <a href="<%= request.getContextPath() %>/courses/graphics.jsp">Компьютерная графика</a>
                <a href="<%= request.getContextPath() %>/courses/python1.jsp">Программирование Python</a>
                <a href="<%= request.getContextPath() %>/courses/python2.jsp">Программирование Python. Ступень 2</a>
                <a href="<%= request.getContextPath() %>/courses/jslang.jsp">Программирование Java Script</a>
                <a href="<%= request.getContextPath() %>/courses/phplang.jsp">Программирование PHP + базы данных MySQL</a>
                <a href="<%= request.getContextPath() %>/courses/javalang.jsp">Программирование Java</a>
                <a href="<%= request.getContextPath() %>/courses/cplusplus.jsp">Программирование C++</a>
                <a href="<%= request.getContextPath() %>/courses/webtech.jsp">Основы Web-технологий</a>
            </div>
        </button>
        <button><a href="<%= request.getContextPath() %>/gallery.jsp">Фотогалерея</a></button>
        <button><a href="<%= request.getContextPath() %>/contacts.jsp">Контакты</a></button>
        <button><a href="<%= request.getContextPath() %>/student/index_student.jsp"><b>☺<%=login%></b></a></button>
    </div>
    <div class="info_auth">
        <div class="auth_info_text1">Входящие сообщения</div>
        <div class="user_input">
            <table border=1 width="95%">
                <col style="width:5%">
                <col style="width:15%">
                <col style="width:80%">
                <thead>
                </thead>
                <th>id</th><th>От кого</th><th>Сообщение</th></th>
                <tr>
                    <c:forEach var="message" items="${messages}">
                <tr>
                    <th>${message.id}</th>
                    <th>${message.from}</th>
                    <th>${message.text_mes}</th>
                    <th><a href='<c:url value="/answerMessageServlet?from=${message.from}"/>'>
                        <input id="edit_btn" type="submit" value="Ответить">
                    </a>
                </tr>
                </c:forEach>
                </tr>
            </table>
        </div>
        <div class="user_input">
            <a href='<c:url value="/newMessageServlet"/>'>
                <input type="submit" value="Новое сообщение" style="margin: 20px;">
            </a>
        </div>
        <div class="user_input">
            <a href='<c:url value="/messagesOutListServlet"/>'>
                <input type="submit" value="Отправленные" style="margin: 20px;">
            </a>
        </div>
    </div>
    <div class="footer">
        <div class="footer_cont1">
            <div class="footer_cont1">
                <img src="resources/img/logo.png" alt="logo" width="100px" height="100px">
            </div>
            <div class="footer_cont12">.TECH</div>
        </div>
        <div class="footer_text1">© Все права защищены .TECH, 2022</div>
        <div class="footer_cont2">
            <div class="footer_text2">Присоединяйтесь к нам</div>
            <div class="footer_img">
                <div class="footer_img1">
                    <a href="#"><img class="footer_img" src="resources/img/facebook.png" alt="logo" width="50px" height="50px"></a>
                </div>
                <div class="footer_img1">
                    <a href="#"><img class="footer_img" src="resources/img/vk.png" alt="logo" width="50px" height="50px"></a>
                </div>
                <div class="footer_img1">
                    <a href="#"><img class="footer_img" src="resources/img/telegram.png" alt="logo" width="50px" height="50px"></a>
                </div>
                <div class="footer_img1">
                    <a href="#"><img class="footer_img" src="resources/img/instagram.png" alt="logo" width="50px" height="50px"></a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
