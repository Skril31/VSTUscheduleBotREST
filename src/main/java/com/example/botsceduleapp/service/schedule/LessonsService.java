package com.example.botsceduleapp.service.schedule;

import com.example.botsceduleapp.model.Schedule.Groups;
import com.example.botsceduleapp.model.Schedule.Lessons;
import com.example.botsceduleapp.model.Schedule.Subjects;
import com.example.botsceduleapp.model.Schedule.Teacher;

import java.util.List;

public interface LessonsService {
    void create(Lessons lessons);


    List<Lessons> readAll();


    Lessons read(int id);


    boolean update(Lessons lessons,int id);


    boolean delete(int id);

    List<Lessons> findLessonsByTeacher(String fio);
    List<Lessons> findLessonsByWeekDayAndWeekTypeAndGroupsGroupNameAndGroupsSubgroup(String weekDay, Integer weekType, String grName, Integer sub);
    List<Lessons> findLessonsByWeekTypeAndGroupsGroupName(Integer weekType, String group);
}
