<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String login = (String) session.getAttribute("login");
    if (login==null)
    {
        login = "Личный кабинет";
    }
%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <title>Фотогалерея</title>
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
        <button><a href="index.jsp">Главная</a></button>
        <button class="dropdown">
            <a href="courses.jsp">Направления обучения</a>
            <div class="menu_dropdown">
                <a href="courses/android.jsp">Разработка приложений на Android</a>
                <a href="courses/graphics.jsp">Компьютерная графика</a>
                <a href="courses/python1.jsp">Программирование Python</a>
                <a href="courses/python2.jsp">Программирование Python. Ступень 2</a>
                <a href="courses/jslang.jsp">Программирование Java Script</a>
                <a href="courses/phplang.jsp">Программирование PHP + базы данных MySQL</a>
                <a href="courses/javalang.jsp">Программирование Java</a>
                <a href="courses/cplusplus.jsp">Программирование C++</a>
                <a href="courses/webtech.jsp">Основы Web-технологий</a>
            </div>
        </button>
        <button><a href="gallery.jsp">Фотогалерея</a></button>
        <button><a href="contacts.jsp">Контакты</a></button>
        <button><a href="auth"><b>☺<%=login%></b></a></button>
    </div>
    <div class="info_auth">
        <div class="cond_main">
            <img src="resources/img/img1.jpg" width="950" height="650" class="info_main_image" alt="">
        </div>
        <div class="info_text_carousel"><b>Жизнь в мире компьютерных технологий:</b></div>
        <div class="wrapper">
            <input type="radio" name="point" id="slide1" checked>
            <input type="radio" name="point" id="slide2">
            <input type="radio" name="point" id="slide3">
            <input type="radio" name="point" id="slide4">
            <input type="radio" name="point" id="slide5">
            <input type="radio" name="point" id="slide6">
            <input type="radio" name="point" id="slide7">
            <div class="slider">
                <div class="slides slide1"></div>
                <div class="slides slide2"></div>
                <div class="slides slide3"></div>
                <div class="slides slide4"></div>
                <div class="slides slide5"></div>
                <div class="slides slide6"></div>
                <div class="slides slide7"></div>
            </div>
            <div class="controls">
                <label for="slide1"></label>
                <label for="slide2"></label>
                <label for="slide3"></label>
                <label for="slide4"></label>
                <label for="slide5"></label>
                <label for="slide6"></label>
            </div>
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
