<%@ page contentType="text/html; charset=UTF-8" %>
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
    <title>Главная</title>
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
        <div class="contact_info_h1">Добро пожаловать в компьютерную школу .TECH!</div>
        <div class="cond_main">
            <div class="cond_info12">Наше учебное заведение специализируется на обучении всех желающих современным информационным технологиям, столь необходимым не только для развития образовательного уровня учащихся, но и для получения широких возможностей при выборе профессии. Педагоги школы - не новички в своем деле. Профессионализм, практический опыт, компетентность - отличительные особенности нашего педагогического коллектива.
            </div>
            <img src="resources/img/cond1.jpg" width="800" height="500" class="info_main_image" alt="">
            <div class="cond_info12"><b>Мы предлагаем учащимся освоить основные направления компьютерных наук:</b>
                <div class="cond_info112">
                    <ul>
                        <li>Разработка приложений на Android</li>
                        <li>Компьютерная графика</li>
                        <li>Программирование Python</li>
                        <li>Программирование Python. Ступень 2</li>
                        <li>Программирование Java Script</li>
                        <li>Программирование PHP + базы данных MySQL</li>
                        <li>Программирование Java</li>
                        <li>Программирование C++</li>
                        <li>Основы Web-технологий</li>
                    </ul>
                </div>
            </div>
            <div class="cond_info12">Помимо учебных занятий проводятся различные мероприятия: конкурсы, викторины, просмотр познавательных фильмов, различные развивающие и подвижные игры, компьютерный спорт.
            </div>
            <img src="resources/img/cond2.jpg" class="info_main_image" alt="">
            <div class="cond_info12">Парамеры ПК в наших аудиториях:
                <div class="cond_info112">
                    <ul>
                        <li>Window 10</li>
                        <li>ОЗУ 8Гб</li>
                        <li>Видеокарта: NVIDIA GeForce GTX660 2Гб</li>
                        <li>Объем жесткого диска 1 Тб</li>
                        <li>Процессор Intel i5 3.40 Гц</li>
                        <li>Монитор 19 дюймов</li>
                    </ul>
                </div>
            </div>
            <div class="contact_info_h1">Как начать обучение?</div>
            <div class="contact_info12">
                <img src="resources/img/choice.png" alt="label" width="50px" height="50px">
                <div class="contact_info112">Подберите для себя программу обучения из катагола, который включает в себя 9 учебных программ по разным направлениям и технологиям</div>
            </div>
            <div class="contact_info12">
                <img src="resources/img/phone.png" alt="label" width="50px" height="50px">
                <div class="contact_info112">Запишитесь на программу обучения по телефону +7(123)456-78-90 или оставьте электронную заявку на сайте</div>
            </div>
            <div class="contact_info12">
                <img src="resources/img/write.png" alt="label" width="50px" height="60px">
                <div class="contact_info112">Заключите договор на обучение с организацией, для этого потребуется паспорт и фото</div>
            </div>
            <div class="contact_info12">
                <img src="resources/img/learn.png" alt="label" width="50px" height="50px">
                <div class="contact_info112">Приступайте к занятиям в группе. По окончании обучения слушатели получают сертификат</div>
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