package com.example.botsceduleapp.repository.schedule;

import com.example.botsceduleapp.model.Schedule.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepository extends JpaRepository<Groups,Integer> {
}
