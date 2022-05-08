package ru.computer_courses.dao;

import ru.computer_courses.model.CourseList;

import java.util.ArrayList;
import java.sql.*;

public class CourseListDB {

    private static String url = "jdbc:mysql://node186572-env-9109343.jelastic.regruhosting.ru/computer_courses?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
    private static String username = "root";
    private static String password = "LCOaam90587";

    public static ArrayList<CourseList> select() {

        ArrayList<CourseList> courses = new ArrayList<CourseList>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM course");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String short_desc = resultSet.getString(3);
                    String description = resultSet.getString(4);
                    String teacher = resultSet.getString(5);

                    CourseList course = new CourseList(id, name, short_desc, description, teacher);
                    courses.add(course);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return courses;
    }
    public static CourseList selectOne(int id) {

        CourseList course = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM course WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int userid = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String short_desc = resultSet.getString(3);
                        String description = resultSet.getString(4);
                        String teacher = resultSet.getString(5);

                        course = new CourseList(userid, name, short_desc, description, teacher);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return course;
    }
    public static int update(CourseList course) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE course SET name = ?, short_desc = ?, description = ?, teacher = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, course.getName());
                    preparedStatement.setString(2, course.getShort_desc());
                    preparedStatement.setString(3, course.getDescription());
                    preparedStatement.setString(4, course.getTeacher());
                    preparedStatement.setInt(5, course.getId());

                    return preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM course WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int insert(CourseList course) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO course (name, short_desc, description, teacher) Values (?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, course.getName());
                    preparedStatement.setString(2, course.getShort_desc());
                    preparedStatement.setString(3, course.getDescription());
                    preparedStatement.setString(4, course.getTeacher());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static ArrayList<CourseList> selectTeacher(String teacher) {

        ArrayList<CourseList> courses = new ArrayList<CourseList>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM course WHERE teacher=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, teacher);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()){
                        int id = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String short_desc = resultSet.getString(3);
                        String description = resultSet.getString(4);
                        String teacher_course = resultSet.getString(5);

                        CourseList course = new CourseList(id, name, short_desc, description, teacher_course);
                        courses.add(course);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return courses;
    }
    public static ArrayList<CourseList> userSearch(String usersearch1, String usersearch2) {

        ArrayList<CourseList> courses = new ArrayList<CourseList>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM course WHERE name LIKE ? OR name LIKE ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, usersearch1);
                    preparedStatement.setString(2, usersearch2);
                    System.out.println(preparedStatement);
                    ResultSet resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            int id = resultSet.getInt(1);
                            String name = resultSet.getString(2);
                            String short_desc = resultSet.getString(3);
                            String description = resultSet.getString(4);
                            String teacher_course = resultSet.getString(5);
                            String link = "";
                            if (name.equals("Разработка приложений на Android")) {
                                link = "courses/android.jsp";
                            } else if (name.equals("Компьютерная графика")) {
                                link = "courses/graphics.jsp";
                            } else if (name.equals("Программирование Python")) {
                                link = "courses/python1.jsp";
                            } else if (name.equals("Программирование Python. Ступень 2")) {
                                link = "courses/python2.jsp";
                            } else if (name.equals("Программирование Java Script")) {
                                link = "courses/jslang.jsp";
                            } else if (name.equals("Программирование PHP + базы данных MySQL")) {
                                link = "courses/phplang.jsp";
                            } else if (name.equals("Программирование Java")) {
                                link = "courses/javalang.jsp";
                            } else if (name.equals("Программирование C++")) {
                                link = "courses/cplusplus.jsp";
                            } else if (name.equals("Основы Web-технологий")) {
                                link = "courses/webtech.jsp";
                            }
                            CourseList course = new CourseList(id, name, short_desc, description, teacher_course, link);
                            courses.add(course);
                        }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return courses;
    }
}
