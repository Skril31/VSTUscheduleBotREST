package com.example.botsceduleapp.service.schedule;

import com.example.botsceduleapp.model.Schedule.Subjects;


import java.util.List;

public interface SubjectsService {

    void create(Subjects subjects);


    List<Subjects> readAll();


    Subjects read(int id);


    boolean update(Subjects subjects,int id);


    boolean delete(int id);
}
