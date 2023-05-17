package com.example.botsceduleapp.service.schedule;

import com.example.botsceduleapp.conect.Connection;
import com.example.botsceduleapp.model.Schedule.Teacher;
import com.example.botsceduleapp.analiticRequests.schedule;
import com.example.botsceduleapp.repository.schedule.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service

public class TeacherServiceImp implements TeacherService {
    @Autowired
    private final TeacherRepository teacherRepository;

    TeacherServiceImp (TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }
    @Override
    public void create(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> readAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher read(int id) {
        List<Teacher> lst= teacherRepository.findAll();
        for (Teacher teacher:lst){
            if (teacher.getId() == id){
                return teacher;
            }
        }
        return null;
    }

    @Override
    public boolean update(Teacher teacher, int id) {
        if (teacherRepository.existsById(id)){
            teacher.setId(id);
            teacherRepository.save(teacher);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (teacherRepository.existsById(id)){
            teacherRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public List<schedule> Teacherschedule(String fio){
        String SQL_FUNC_QUERY = """
                SELECT "subjects"."name","lessons"."week_day","lessons"."start_time","lessons"."end_time","week_type"."type"\s
                                      FROM Public."subjects"
                                        JOIN Public."lessons" ON "subjects"."id"="lessons"."id_subject"
                                        JOIN Public."teachers" ON "teachers"."id"="lessons"."id_teacher"
                                        JOIN Public."week_type" ON "lessons"."id_week" = "week_type"."id"
                                        WHERE "teachers"."fio"=?""";
        try {
            PreparedStatement preparedStatement = Connection.db.prepareStatement(SQL_FUNC_QUERY);
            preparedStatement.setString(1,fio);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<schedule> schedules = new ArrayList<>();
            while (resultSet.next()){
                schedule sc = new schedule();
                sc.setSub_name(resultSet.getString("name"));
                sc.setWeek_day(resultSet.getString("week_day"));
                sc.setStart_time(resultSet.getString("start_time"));
                sc.setEnd_time(resultSet.getString("end_time"));
                sc.setType(resultSet.getInt("type"));
                schedules.add(sc);
            }
            return schedules;
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<schedule> GroupFilter(String group, int subgroup) {
        String SQL_QUERY = """
                SELECT "subjects"."name","lessons"."week_day","lessons"."start_time","lessons"."end_time"
                FROM Public."subjects"
                JOIN Public."lessons" ON "subjects"."id"="lessons"."id_subject"
                JOIN Public."groups" ON "groups"."id"="lessons"."id_group"
                WHERE "groups"."group_name"=? AND "groups"."subgroup"=?""";
        try {
            PreparedStatement preparedStatement = Connection.db.prepareStatement(SQL_QUERY);
            preparedStatement.setString(1,group);
            preparedStatement.setInt(2,subgroup);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<schedule> schedules = new ArrayList<>();
            while (resultSet.next()){
                schedule sc = new schedule();
                sc.setSub_name(resultSet.getString("name"));
                sc.setWeek_day(resultSet.getString("week_day"));
                sc.setStart_time(resultSet.getString("start_time"));
                sc.setEnd_time(resultSet.getString("end_time"));
                schedules.add(sc);
            }
            return schedules;
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
