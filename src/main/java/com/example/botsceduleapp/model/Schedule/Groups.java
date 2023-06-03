package com.example.botsceduleapp.model.Schedule;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "groups")
public class Groups {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "group_name")
    private String groupName;

    @Column(name = "subgroup")
    private Integer subgroup;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groups", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Lessons> lessons;
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setSubgroup(Integer subgroup) {
        this.subgroup = subgroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    public Integer getSubgroup() {
        return subgroup;
    }

    public List<Lessons> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lessons> lessons) {
        this.lessons = lessons;
    }
}
