package com.example.botsceduleapp.repository.schedule;

import com.example.botsceduleapp.model.Schedule.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subjects,Integer> {
}
