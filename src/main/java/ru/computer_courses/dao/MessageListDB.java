package ru.computer_courses.dao;

import ru.computer_courses.model.MessageList;

import java.util.ArrayList;
import java.sql.*;

public class MessageListDB {

    private static String url = "jdbc:mysql://node186572-env-9109343.jelastic.regruhosting.ru/computer_courses?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
    private static String username = "root";
    private static String password = "LCOaam90587";

    public static ArrayList<MessageList> selectOneIn(String email) {

        ArrayList<MessageList> messages = new ArrayList<MessageList>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM message WHERE whom=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, email);
                    System.out.println(preparedStatement);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()){
                        int id = resultSet.getInt(1);
                        String from = resultSet.getString(2);
                        String whom = resultSet.getString(3);
                        String text_mes = resultSet.getString(4);

                        MessageList message = new MessageList(id, from, whom, text_mes);
                        messages.add(message);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return messages;
    }
    public static ArrayList<MessageList> selectOneOut(String email) {

        ArrayList<MessageList> messages = new ArrayList<MessageList>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM message WHERE from_mes=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, email);
                    System.out.println(preparedStatement);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()){
                        int id = resultSet.getInt(1);
                        String from = resultSet.getString(2);
                        String whom = resultSet.getString(3);
                        String text_mes = resultSet.getString(4);

                        MessageList message = new MessageList(id, from, whom, text_mes);
                        messages.add(message);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return messages;
    }
    public static int answerMessage(MessageList message) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO  message (from_mes, whom, text_mes) VALUES (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, message.getFrom());
                    preparedStatement.setString(2, message.getWhom());
                    preparedStatement.setString(3, message.getText_mes());
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
