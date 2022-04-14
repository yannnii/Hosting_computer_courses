package ru.computer_courses.model;

import java.io.Serializable;

public class CourseList implements Serializable {
    private int id;
    private String name;
    private String short_desc;
    private String description;
    private String teacher;
    private String link;

    public CourseList(){ }
    public CourseList(String name, String short_desc, String description, String teacher){

        this.name = name;
        this.short_desc = short_desc;
        this.description = description;
        this.teacher = teacher;
    }

    public CourseList(int id, String name, String short_desc, String description, String teacher){

        this.id = id;
        this.name = name;
        this.short_desc = short_desc;
        this.description = description;
        this.teacher = teacher;
    }

    public CourseList(int id, String name, String short_desc, String description, String teacher, String link){

        this.id = id;
        this.name = name;
        this.short_desc = short_desc;
        this.description = description;
        this.teacher = teacher;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
