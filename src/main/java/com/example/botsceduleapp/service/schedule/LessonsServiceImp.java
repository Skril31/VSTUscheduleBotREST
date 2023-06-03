package com.example.botsceduleapp.service.schedule;

import com.example.botsceduleapp.model.Schedule.Groups;
import com.example.botsceduleapp.model.Schedule.Lessons;
import com.example.botsceduleapp.model.Schedule.Teacher;
import com.example.botsceduleapp.repository.schedule.LessonsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LessonsServiceImp implements LessonsService{
    LessonsRepository lessonsRepository;

    public LessonsServiceImp(LessonsRepository lessonsRepository) {
        this.lessonsRepository = lessonsRepository;
    }

    @Override
    public void create(Lessons lessons) {
        lessonsRepository.save(lessons);
    }

    @Override
    public List<Lessons> readAll() {
        return lessonsRepository.findAll();
    }

    @Override
    public Lessons read(int id) {
        Optional<Lessons> les = lessonsRepository.findById(id);
        if (les.isPresent()){
            return les.get();
        }
        return null;
    }

    @Override
    public boolean update(Lessons lessons, int id) {
        if (lessonsRepository.existsById(id)){
            lessons.setId(id);
            lessonsRepository.save(lessons);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (lessonsRepository.existsById(id)){
            lessonsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Lessons> findLessonsByTeacher(String fio) {

        return lessonsRepository.findLessonsByTeacherFio(fio);
    }

    @Override
    public List<Lessons> findLessonsByWeekDayAndWeekTypeAndGroupsGroupNameAndGroupsSubgroup(String weekDay, Integer weekType, String grName, Integer sub) {
        return lessonsRepository.findLessonsByWeekDayAndWeekTypeAndGroupsGroupNameAndGroupsSubgroup(weekDay,weekType,grName,sub);
    }

    @Override
    public List<Lessons> findLessonsByWeekTypeAndGroupsGroupName(Integer weekType, String group) {
        return lessonsRepository.findLessonsByWeekTypeAndGroupsGroupName(weekType,group);
    }
}
