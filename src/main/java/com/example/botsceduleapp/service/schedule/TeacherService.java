package com.example.botsceduleapp.service.schedule;

import com.example.botsceduleapp.model.Schedule.Teacher;
import com.example.botsceduleapp.model.schedule;

import java.util.List;

public interface TeacherService {
    /**
     * Создание нового преподавателя
     * @param teacher - преподаватель для создания
     */
    void create(Teacher teacher);

    /**
     * Возвращает список со всеми преподавателями
     * @return - возвращает список с преподавателями
     */
    List<Teacher> readAll();

    /**
     * Возвращает преподавателя по id
     * @param id - id возвращаемого преподавателя
     * @return - объект преподавателя с заданным id
     */
    Teacher read(int id);

    /**
     * Обновляет преподавателя по id
     * в соответствии с заданным преподавателем
     * @param teacher - объект преподавателя на который необходимо обновить
     * @param id - id преподавателя которого хотим обновить
     * @return - возвращает успешна ли была операция
     */
    boolean update(Teacher teacher,int id);

    /**
     *
     * @param id
     * @return
     */
    boolean delete(int id);

    List<schedule> Teacherschedule(String fio);
    List<schedule> GroupFilter(String group, int subgroup);

}
