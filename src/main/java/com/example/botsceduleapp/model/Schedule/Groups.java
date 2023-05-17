package com.example.botsceduleapp.model.Schedule;

import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Groups {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "group_name")
    private String group_name;

    @Column(name = "subgroup")
    private Integer subgroup;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setSubgroup(Integer subgroup) {
        this.subgroup = subgroup;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }


    public Integer getSubgroup() {
        return subgroup;
    }


}
