package ru.computer_courses.dao;

import ru.computer_courses.model.UserList;

import java.util.ArrayList;
import java.sql.*;

public class UserListDB {

    private static String url = "jdbc:mysql://localhost:3306/computer_courses?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
    private static String username = "root";
    private static String password = "root";

    public static ArrayList<UserList> select() {

        ArrayList<UserList> users = new ArrayList<UserList>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    String login = resultSet.getString(4);
                    String password = resultSet.getString(5);
                    String email = resultSet.getString(6);
                    String gender = resultSet.getString(7);
                    String userRole = resultSet.getString(8);
                    String city = resultSet.getString(9);
                    String consent = resultSet.getString(10);
                    UserList user = new UserList(id, name, surname, login, password, email, gender, userRole, city, consent);
                    users.add(user);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return users;
    }

    public static UserList selectOne(int id) {

        UserList user = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM user WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int userid = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String surname = resultSet.getString(3);
                        String login = resultSet.getString(4);
                        String password = resultSet.getString(5);
                        String email = resultSet.getString(6);
                        String gender = resultSet.getString(7);
                        String userRole = resultSet.getString(8);
                        String city = resultSet.getString(9);
                        String consent = resultSet.getString(10);
                        user = new UserList(userid, name, surname, login, password, email, gender, userRole, city, consent);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return user;
    }
    public static int update(UserList user) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE user SET name = ?, surname = ?, login = ?, password = ?, email = ?, gender = ?, role = ?, city = ?, consent = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, user.getName());
                    preparedStatement.setString(2, user.getSurname());
                    preparedStatement.setString(3, user.getLogin());
                    preparedStatement.setString(4, user.getPassword());
                    preparedStatement.setString(5, user.getEmail());
                    preparedStatement.setString(6, user.getGender());
                    preparedStatement.setString(7, user.getUserRole());
                    preparedStatement.setString(8, user.getCity());
                    preparedStatement.setString(9, user.getConsent());
                    preparedStatement.setInt(10, user.getId());

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

                String sql = "DELETE FROM user WHERE id = ?";
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
}
