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
    <title>Программирование Python. Ступень 2</title>
    <link rel="stylesheet" href="../resources/style.css">
    <link type="image/x-icon" href="../resources/img/logo.png" rel="shortcut icon">
</head>
<body>
<div class="content">
    <div class="header">
        <div class="header1">
            <div class="header1_cont1">
                <div class="header1_cont11">
                    <img src="../resources/img/logo.png" alt="logo" width="130px" height="130px">
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
            <form name="search" method="post" action="../findCoursesServlet">
                <input id="search" name="usersearch" placeholder="Поиск по курсам" type="text" required>
                <input type="submit" value="Поиск" style="height: 32px; width: 80px; padding: 0; border-radius: 3px; font-size: 16px; margin-right: 10px; border: 1px solid #CCCCFF"/>
            </form>
        </div>
    </div>
    <div class="menu">
        <button><a href="../index.jsp">Главная</a></button>
        <button class="dropdown">
            <a href="../courses.jsp">Направления обучения</a>
            <div class="menu_dropdown">
                <a href="android.jsp">Разработка приложений на Android</a>
                <a href="graphics.jsp">Компьютерная графика</a>
                <a href="python1.jsp">Программирование Python</a>
                <a href="python2.jsp">Программирование Python. Ступень 2</a>
                <a href="jslang.jsp">Программирование Java Script</a>
                <a href="phplang.jsp">Программирование PHP + базы данных MySQL</a>
                <a href="javalang.jsp">Программирование Java</a>
                <a href="cplusplus.jsp">Программирование C++</a>
                <a href="webtech.jsp">Основы Web-технологий</a>
            </div>
        </button>
        <button><a href="../gallery.jsp">Фотогалерея</a></button>
        <button><a href="../contacts.jsp">Контакты</a></button>
        <button><a href="../auth"><b>☺<%=login%></b></a></button>
    </div>
    <div class="info">
        <div class="contact_info_h1">Программирование Python. Ступень 2</div>
        <div class="course_main">
            <div class="course_main1">
                <div class="course_img">
                    <img src="../resources/img/python22.jpg" width="700" height="500" class="info_main_image" alt="">
                </div>
            </div>
            <div class="course_main1">
                <div class="cond_info12">Профессиональный онлайн-курс для тех, кто уже имеет опыт программирования на Python и хочет повысить свой уровень за счет новых знаний и навыков из различных областей разработки. Если вы уверенно чувствуете себя с Python, помните C, имеете представление о сетевом взаимодействии и реляционных СУБД, умеете обращаться с Linux, Git и прочими стандартными инструментами девелопера — курс для вас.
                </div>
                <div class="info11">
                    <button class="course"><a href="../enrollCourse?course_name=Программирование Python. Ступень 2&teacher_email=ivansidorov2@yandex.ru">Записаться</a></button>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="footer_cont1">
            <div class="footer_cont1">
                <img src="../resources/img/logo.png" alt="logo" width="100px" height="100px">
            </div>
            <div class="footer_cont12">.TECH</div>
        </div>
        <div class="footer_text1">© Все права защищены .TECH, 2022</div>
        <div class="footer_cont2">
            <div class="footer_text2">Присоединяйтесь к нам</div>
            <div class="footer_img">
                <div class="footer_img1">
                    <a href="#"><img class="footer_img" src="../resources/img/facebook.png" alt="logo" width="50px" height="50px"></a>
                </div>
                <div class="footer_img1">
                    <a href="#"><img class="footer_img" src="../resources/img/vk.png" alt="logo" width="50px" height="50px"></a>
                </div>
                <div class="footer_img1">
                    <a href="#"><img class="footer_img" src="../resources/img/telegram.png" alt="logo" width="50px" height="50px"></a>
                </div>
                <div class="footer_img1">
                    <a href="#"><img class="footer_img" src="../resources/img/instagram.png" alt="logo" width="50px" height="50px"></a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>