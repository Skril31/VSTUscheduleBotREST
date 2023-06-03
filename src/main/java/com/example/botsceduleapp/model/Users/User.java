package com.example.botsceduleapp.model.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @Column(name = "id_tg")
    private Integer id;

    @Column(name = "groups")
    private String group;

    @Column(name = "subgroup")
    private Integer subgroup;

    @Column(name = "master")
    private Integer master;

    //@Column(name = "chat_id")
    //private Integer chatId;


    public Integer getMaster() {
        return master;
    }

    public void setMaster(Integer master) {
        this.master = master;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setSubgroup(Integer subgroup) {
        this.subgroup = subgroup;
    }

    public Integer getSubgroup() {
        return subgroup;
    }
}
