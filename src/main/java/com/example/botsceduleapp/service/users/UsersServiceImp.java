package com.example.botsceduleapp.service.users;

import com.example.botsceduleapp.model.Users.User;
import com.example.botsceduleapp.repository.users.UsersRepository;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServiceImp implements UsersService{
    @Autowired
    private final UsersRepository usersRepository;

    UsersServiceImp(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public void create(User user) {
        usersRepository.save(user);
    }

    @Override
    public User read(int id) {
        return usersRepository.getOne(id);
    }

    @Override
    public List<User> readAll() {
        return usersRepository.findAll();
    }

    @Override
    public boolean update(User user, int id) {
        if (usersRepository.existsById(id)){
            user.setId(id);
            usersRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (usersRepository.existsById(id)){
            usersRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
