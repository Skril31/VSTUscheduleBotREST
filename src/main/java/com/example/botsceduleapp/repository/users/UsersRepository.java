package com.example.botsceduleapp.repository.users;

import com.example.botsceduleapp.model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User,Integer> {
    List<User> findUsersByGroupAndSubgroup(String group, Integer sub);
    List<User> findUsersByGroup(String group);
}
