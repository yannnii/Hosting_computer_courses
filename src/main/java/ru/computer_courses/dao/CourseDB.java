package ru.computer_courses.dao;

import ru.computer_courses.model.Course;

import java.util.ArrayList;
import java.sql.*;

public class CourseDB {

    private static String url = "jdbc:mysql://node186572-env-9109343.jelastic.regruhosting.ru/computer_courses?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
    private static String username = "root";
    private static String password = "LCOaam90587";

    public static ArrayList<Course> selectOne(String email) {

        ArrayList<Course> courses = new ArrayList<Course>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM course_enrollment WHERE student_email=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, email);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()){
                        int id = resultSet.getInt(1);
                        String course_name = resultSet.getString(2);
                        String student_email = resultSet.getString(3);
                        String teacher_email = resultSet.getString(4);
                        Course course = new Course(id, course_name, student_email, teacher_email);
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
    public static int insert(Course course) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO course_enrollment (course_name, student_email, teacher_email) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, course.getCourse_name());
                    preparedStatement.setString(2, course.getStudent_email());
                    preparedStatement.setString(3, course.getTeacher_email());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
