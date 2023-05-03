package com.example.botsceduleapp.model.Ads;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ads")
public class Ad {
    @Id
    private String id;
    private String teacher_name;
    private String text;
    private String groups;
    private int subgroup;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setSubgroup(int subgroup) {
        this.subgroup = subgroup;
    }

    public int getSubgroup() {
        return subgroup;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

