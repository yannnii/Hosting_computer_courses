package ru.computer_courses.model;

import java.io.Serializable;

public class Course implements Serializable {
    private int id;
    private String course_name;
    private String student_email;
    private String teacher_email;

    public Course(){ }
    public Course(String course_name, String student_email, String teacher_email){

        this.course_name = course_name;
        this.student_email = student_email;
        this.teacher_email = teacher_email;
    }

    public Course(int id, String course_name, String student_email, String teacher_email){

        this.id = id;
        this.course_name = course_name;
        this.student_email = student_email;
        this.teacher_email = teacher_email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

}
