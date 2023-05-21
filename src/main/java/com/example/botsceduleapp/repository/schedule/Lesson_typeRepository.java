package com.example.botsceduleapp.repository.schedule;

import com.example.botsceduleapp.model.Schedule.lesson_type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Lesson_typeRepository extends JpaRepository<lesson_type,Integer> {
}
