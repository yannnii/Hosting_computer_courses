package ru.computer_courses.model;

import java.io.Serializable;

public class MessageList implements Serializable {
    private int id;
    private String from;
    private String whom;
    private String text_mes;

    public MessageList(){ }
    public MessageList(String from, String whom, String text_mes){

        this.from = from;
        this.whom = whom;
        this.text_mes = text_mes;
    }

    public MessageList(int id, String from, String whom, String text_mes){

        this.id = id;
        this.from = from;
        this.whom = whom;
        this.text_mes = text_mes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getWhom() {
        return whom;
    }

    public void setWhom(String whom) {
        this.whom = whom;
    }

    public String getText_mes() {
        return text_mes;
    }

    public void setText_mes(String text_mes) {
        this.text_mes = text_mes;
    }



}
