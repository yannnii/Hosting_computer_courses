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
    <title>Направления обучения</title>
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
    <div class="info">
        <div class="info1">
            <div class="info11">
                <img class="info_img" src="resources/img/android.jpg" alt="android" width="300px" height="300px">
            </div>
            <div class="info11">Разработка приложений на Android</div>
            <div class="info12">Научитесь с нуля создавать мобильные приложения под Android и программировать на Java и Kotlin. Получите знания и навыки, необходимые для создания проектов уровня middle-специалиста</div>
            <div class="info11">
                <button class="course"><a href="courses/android.jsp">подробнее</a></button>
            </div>
        </div>
        <div class="info1">
            <div class="info11">
                <img class="info_img" src="resources/img/graphics.jpg" alt="graphics" width="300px" height="300px">
            </div>
            <div class="info11">Компьютерная графика</div>
            <div class="info12">Программа курса «Компьютерная графика» предназначена для подготовки детей, желающих освоить современные способы создания и редактирования векторных иллюстраций, а также желающих освоить современные способы обработки фотографий</div>
            <div class="info11">
                <button class="course"><a href="courses/graphics.jsp">подробнее</a></button>
            </div>
        </div>
        <div class="info1">
            <div class="info11">
                <img class="info_img" src="resources/img/python1.png" alt="python1" width="300px" height="300px">
            </div>
            <div class="info11">Программирование Python</div>
            <div class="info12">Программа уровня разработана для ребят, желающих быть не только продвинутыми пользователями, но и настоящими разработчиками современных it-проектов. Ребенок будет знать основы объектно–ориентированного программирования и основы компьютерной графики Python.</div>
            <div class="info11">
                <button class="course"><a href="courses/python1.jsp">подробнее</a></button>
            </div>
        </div>
        <div class="info1">
            <div class="info11">
                <img class="info_img" src="resources/img/python2.png" alt="python2" width="300px" height="300px">
            </div>
            <div class="info11">Программирование Python. Ступень 2</div>
            <div class="info12">Программирование Python 2 ступень! Когда уже весь язык Python пройден- настало время создания бекенда для разработки веб сайтов!</div>
            <div class="info11">
                <button class="course"><a href="courses/python2.jsp">подробнее</a></button>
            </div>
        </div>
        <div class="info1">
            <div class="info11">
                <img class="info_img" src="resources/img/js.jpg" alt="js" width="300px" height="300px">
            </div>
            <div class="info11">Программирование Java Script</div>
            <div class="info12">Ученики знакомятся с синтаксисом языка JavaScript, учатся писать сценарии для создания интерактивных элементов сайтов, получают базовый опыт в сайтостроении, необходимый для создания собственного сайта и для дальнейшего профессионального роста в качестве вебразработчика.</div>
            <div class="info11">
                <button class="course"><a href="courses/jslang.jsp">подробнее</a></button>
            </div>
        </div>
        <div class="info1">
            <div class="info11">
                <img class="info_img" src="resources/img/php.png" alt="php" width="300px" height="300px">
            </div>
            <div class="info11">Программирование PHP + базы данных MySQL</div>
            <div class="info12">Ребята научатся создавать на языке PHP мобильные приложения, а также работать с системой управления базами данных, предназначенной для разработки программных комплексов.</div>
            <div class="info11">
                <button class="course"><a href="courses/phplang.jsp">подробнее</a></button>
            </div>
        </div>
        <div class="info1">
            <div class="info11">
                <img class="info_img" src="resources/img/java.jpg" alt="java" width="300px" height="300px">
            </div>
            <div class="info11">Программирование Java</div>
            <div class="info12">Вы научитесь писать код и создавать сайты на самом популярном языке программирования. Разработаете блог, добавите сильный проект в портфолио и станете Java-программистом, которому рады в любой студии разработки.</div>
            <div class="info11">
                <button class="course"><a href="courses/javalang.jsp">подробнее</a></button>
            </div>
        </div>
        <div class="info1">
            <div class="info11">
                <img class="info_img" src="resources/img/c.png" alt="c" width="300px" height="300px">
            </div>
            <div class="info11">Программирование C++</div>
            <div class="info12">Java, JavaScript, C#, как и огромное количество других популярных языков программирования, содержит в основе принципы C++</div>
            <div class="info11">
                <button class="course"><a href="courses/cplusplus.jsp">подробнее</a></button>
            </div>
        </div>
        <div class="info1">
            <div class="info11">
                <img class="info_img" src="resources/img/web.png" alt="web" width="300px" height="300px">
            </div>
            <div class="info11">Основы Web-технологий</div>
            <div class="info12">Опытные преподаватели понятно, просто и логично объясняют основные языки разметки и стилей HTML и CSS, с помощью которых разрабатываются веб-страницы.</div>
            <div class="info11">
                <button class="course"><a href="courses/webtech.jsp">подробнее</a></button>
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
