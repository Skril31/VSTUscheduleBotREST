package com.example.botsceduleapp.model.Schedule;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teachers")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Teacher {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fio")
    private String fio;
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", fetch = FetchType.EAGER)
    private List<Lessons> lessons;

    public void AddLessonToTeacher(Lessons lessons){
        if (lessons==null)
            this.lessons = new ArrayList<>();
        this.lessons.add(lessons);
        lessons.setTeacher(this);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fio='" + fio + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public List<Lessons> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lessons> lessons) {
        this.lessons = lessons;
    }
}
