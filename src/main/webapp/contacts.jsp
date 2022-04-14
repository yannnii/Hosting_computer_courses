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
    <title>Контакты</title>
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
        <div class="contact_info_h1">Вы всегда можете связаться с нами!</div>
        <div class="contact_cont">
            <div class="contact_info">
                <div class="contact_info11">Адрес:</div>
                <div class="contact_info12">
                    <img src="resources/img/label.png" alt="label" width="50px" height="60px">
                    <div class="contact_info112">125009, г. Москва, Тверская улица, дом 13.</div>
                </div>
            </div>
            <div class="contact_info">
                <div class="contact_info11">Режим работы:</div>
                <div class="contact_info12">
                    <img src="resources/img/work.png" alt="label" width="50px" height="50px">
                    <div class="contact_info112">
                        <ul>
                            <li>Пн-Пт <b>9:00-17:00</b></li>
                            <li>Сб-Вс <b>9:00-15:00</b></li>
                            <li>Без обеда</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="contact_cont">
            <div class="contact_info">
                <div class="contact_info11">Телефон:</div>
                <div class="contact_info12">
                    <img src="resources/img/phone.png" alt="label" width="50px" height="50px">
                    <div class="contact_info112">+7 (123) 456-78-90</div>
                </div>
            </div>
            <div class="contact_info">
                <div class="contact_info11">Электронная почта:</div>
                <div class="contact_info12">
                    <img src="resources/img/email.png" alt="label" width="60px" height="50px">
                    <div class="contact_info112">computer_courses@yandex.ru</div>
                </div>
            </div>
        </div>
        <div class="contact_info_h1">Найти нас можно здесь:</div>
        <div class="map">
            <div style="position:relative;overflow:hidden;"><a href="https://yandex.ru/maps/213/moscow/?utm_medium=mapframe&utm_source=maps" style="color:#eee;font-size:12px;position:absolute;top:0px;">Москва</a><a href="https://yandex.ru/maps/213/moscow/house/tverskaya_ulitsa_13/Z04YcAdpSEQOQFtvfXt3cH5mbQ==/?ll=37.609119%2C55.761259&utm_medium=mapframe&utm_source=maps&z=16.31" style="color:#eee;font-size:12px;position:absolute;top:14px;">Тверская улица, 13 — Яндекс Карты</a><iframe src="https://yandex.ru/map-widget/v1/-/CCUBnRh4TC" width="1000px" height="500px" frameborder="1" allowfullscreen="true" style="position:relative;"></iframe></div>
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