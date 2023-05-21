package com.example.botsceduleapp.repository.schedule;

import com.example.botsceduleapp.model.Schedule.Aud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudRepository extends JpaRepository<Aud,Integer> {
}
