package com.example.botsceduleapp.model.Schedule;

import jakarta.persistence.*;



@Entity
@Table(name = "lessons")
public class Lessons {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "week_day")
    private String week_day;

    @Column(name = "start_time")
    private String start_time;

    @Column (name = "end_time")
    private String end_time;
    @Column(name = "week_type")
    private Integer week_type;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_subject")
    private Subjects subjects;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_lesson_type")
    private lesson_type lesson_type;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_group")
    private Groups groups;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_audit")
    private Aud aud;



    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getWeek_day() {
        return week_day;
    }

    public void setWeek_day(String week_day) {
        this.week_day = week_day;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public com.example.botsceduleapp.model.Schedule.lesson_type getLesson_type() {
        return lesson_type;
    }

    public Aud getAud() {
        return aud;
    }

    public Groups getGroups() {
        return groups;
    }


    public Integer getWeek_type() {
        return week_type;
    }

    public void setWeek_type(Integer week_type) {
        this.week_type = week_type;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public void setAud(Aud aud) {
        this.aud = aud;
    }
}
