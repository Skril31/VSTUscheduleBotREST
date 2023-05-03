package com.example.botsceduleapp.model.Schedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity
//@Table
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class schedule {
    //@Id
    private String sub_name;
    private String week_day;
    private String start_time;
    private String end_time;
    private Integer type;

    public String getEnd_time() {
        return end_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getSub_name() {
        return sub_name;
    }

    public Integer getType() {
        return type;
    }

    public String getWeek_day() {
        return week_day;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setWeek_day(String week_day) {
        this.week_day = week_day;
    }

}
