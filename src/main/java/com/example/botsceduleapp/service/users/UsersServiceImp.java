package com.example.botsceduleapp.service.users;

import com.example.botsceduleapp.conect.Connection;
import com.example.botsceduleapp.model.Schedule.schedule;
import com.example.botsceduleapp.model.Schedule.tg_users_an;
import com.example.botsceduleapp.model.Users.User;
import com.example.botsceduleapp.repository.users.UsersRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    public List<tg_users_an> GetByGroup(String group) {
        String SQL_QUERY = """
                SELECT * FROM  users WHERE groups = ?""";

        try {
            PreparedStatement preparedStatement = Connection.db_users.prepareStatement(SQL_QUERY);
            preparedStatement.setString(1,group);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<tg_users_an> users = new ArrayList<>();
            while (resultSet.next()){
                tg_users_an tgUsersAn = new tg_users_an();
                tgUsersAn.setId(resultSet.getLong("id_tg"));
                tgUsersAn.setGroup(resultSet.getString("groups"));
                tgUsersAn.setSub(resultSet.getInt("subgroup"));
                users.add(tgUsersAn);
            }
            return users;
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    }

