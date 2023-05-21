package com.example.botsceduleapp.repository.schedule;

import com.example.botsceduleapp.analiticRequests.schedule;
import com.example.botsceduleapp.model.Schedule.Lessons;
import com.example.botsceduleapp.model.Schedule.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonsRepository extends JpaRepository<Lessons,Integer> {
    List<Lessons> findLessonsByTeacherFio(String fio);
}
