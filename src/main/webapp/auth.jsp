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
    <title>Вход</title>
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
        <div class="auth_info_text1">ВХОД В СИСТЕМУ</div>
        <form name="auth_form" action="<%= request.getContextPath() %>/auth" method="post" onsubmit="return validate()">
            <div class="auth_input">
                <input type="text" name="login" placeholder="Логин" required/>
                <input type="password" name="password" placeholder="Пароль" required/>
                <div class="auth_input" style="font-size: 24px; flex-direction: row; justify-content: center; width: 500px">
                    <div id="str" style="font-size: 24px;"></div>
                    <input class="input-num" type="text" style="font-size: 24px; width: 80px; height: 50px; margin-left: 10px" required>
                </div>
                <div class="auth_input" style="font-size: 24px; flex-direction: row; justify-content: center; width: 500px">
                    <div id="error"></div>
                </div>
                <input type="submit" value="Войти"/>
                <input type="reset" value="Очистить"/>
            </div>
        </form>
        <div class="auth_info_text2"><a class="auth_a" href="registration">Зарегистрируйтесь,</a> если у Вас еще нет аккаунта</div>
    </div>
    <script>
        let num1 = Math.ceil(Math.random() * 10);
        let num2 = Math.ceil(Math.random() * 10);
        let res = num1 + num2;
        document.getElementById("str").innerHTML = num1 + " + " + num2 + " = ";
        function validate()
        {
            let inputNum = document.querySelector(".input-num").value;
            inputNum = parseInt(inputNum);
            if (inputNum === res)
            {
                console.log("Вход разрешён");
            }
            else
            {
                console.log("Вход запрещен");
                num1 = Math.ceil(Math.random() * 10);
                num2 = Math.ceil(Math.random() * 10);
                res = num1 + num2;
                document.getElementById("str").innerHTML = num1 + " + " + num2 + " = ";
                document.getElementById("error").innerHTML="Неверное решение. Повторите ввод";
                return false;
            }
            let username = document.forms["auth_form"]["login"].value;
            let username_regexp = /^[0-9a-zA-z_\d]{6,12}$/;
            if (!username_regexp.test(username))
            {
                document.getElementById("error").innerHTML="Логин должен содержать не менее 6 и не более 12 символов, только буквы латинского алфавита, цифры и подчеркивание";
                return false;
            }

            let pass_regexp = /^[0-9a-zA-z_\d]{6,12}$/;
            let pass = document.forms["auth_form"]["password"].value;
            if (!pass_regexp.test(pass))
            {
                document.getElementById("error").innerHTML="Пароль должен содержать не менее 6 и не более 12 символов, латинские буквы, цифры и подчеркивание";
                return false;
            }
        }
    </script>
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
