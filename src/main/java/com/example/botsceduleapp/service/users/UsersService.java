package com.example.botsceduleapp.service.users;

import com.example.botsceduleapp.analiticRequests.tg_users_an;
import com.example.botsceduleapp.model.Users.User;

import java.util.List;

public interface UsersService {
    /**
     * Создание нового преподавателя
     * @param user - пользователь для создания
     */
    void create(User user);

    /**
     * Возвращает список со всеми пользователями
     * @return - возвращает список с пользователями
     */
    List<User> readAll();

    /**
     * Возвращает пользователя по id
     * @param id - id возвращаемого пользователя
     * @return - объект пользователя с заданным id
     */
    User read(int id);

    /**
     * Обновляет пользователя по id
     * в соответствии с заданным пользователем
     * @param user - объект пользователя на который необходимо обновить
     * @param id - id пользователя которого хотим обновить
     * @return - возвращает успешна ли была операция
     */
    boolean update(User user,int id);

    /**
     *
     * @param id
     * @return
     */
    boolean delete(int id);

    List<tg_users_an> GetByGroup(String fio);
}
