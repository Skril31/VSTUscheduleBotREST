package com.example.botsceduleapp.model.Schedule;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subjects")
public class Subjects {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjects", fetch = FetchType.EAGER)
    private List<Lessons> lessons;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
