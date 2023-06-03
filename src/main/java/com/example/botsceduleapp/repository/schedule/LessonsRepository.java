package com.example.botsceduleapp.repository.schedule;

import com.example.botsceduleapp.model.Schedule.Groups;
import com.example.botsceduleapp.model.Schedule.Lessons;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonsRepository extends JpaRepository<Lessons,Integer> {
    List<Lessons> findLessonsByTeacherFio(String fio);
    List<Lessons> findLessonsByWeekDayAndWeekTypeAndGroupsGroupNameAndGroupsSubgroup(String weekDay, Integer weekType, String grName, Integer sub);
    List<Lessons> findLessonsByWeekTypeAndGroupsGroupName(Integer weekType, String group);
}
