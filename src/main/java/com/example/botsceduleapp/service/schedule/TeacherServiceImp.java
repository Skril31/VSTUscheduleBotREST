package com.example.botsceduleapp.service.schedule;

import com.example.botsceduleapp.model.Schedule.Teacher;
import com.example.botsceduleapp.repository.schedule.TeacherRepository;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TeacherServiceImp implements TeacherService {

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
        return teacherRepository.getOne(id);
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
}
