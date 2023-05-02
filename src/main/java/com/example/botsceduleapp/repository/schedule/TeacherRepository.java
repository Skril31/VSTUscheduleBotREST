package com.example.botsceduleapp.repository.schedule;

import com.example.botsceduleapp.model.Schedule.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
