package com.example.botsceduleapp.controller;

import com.example.botsceduleapp.model.Schedule.Lessons;
import com.example.botsceduleapp.model.Schedule.Teacher;
import com.example.botsceduleapp.analiticRequests.schedule;
import com.example.botsceduleapp.service.schedule.TeacherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TeacherController {
    private final TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }
    @PostMapping(value = "/teachers")
    public ResponseEntity<?> create(@RequestBody Teacher teacher){
        teacherService.create(teacher);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/teachers")
    public ResponseEntity<List<Teacher>> readAll(){
        final List<Teacher> teachers = teacherService.readAll();

        return teachers != null && !teachers.isEmpty()
                ? new ResponseEntity<>(teachers,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/teachers/{id}")
    public ResponseEntity<Teacher> read(@PathVariable(name = "id") int id){
        final Teacher teacher = teacherService.read(id);

        return teacher != null
                ? new ResponseEntity<>(teacher,HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/teachers/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id,@RequestBody Teacher teacher){
        final boolean updated = teacherService.update(teacher,id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/teachers/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean deleted = teacherService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/teachers/{name}/lessons")
    public ResponseEntity<List<schedule>> TeacherFilter(@PathVariable(name = "name") String name){

        List<schedule> schedules = teacherService.Teacherschedule(name);

        return schedules != null && !schedules.isEmpty()
                ? new ResponseEntity<>(schedules,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/groups/{group}/subgroup/{sub}")
    public ResponseEntity<List<schedule>> GroupFilter(@PathVariable(name = "group") String group, @PathVariable(name = "sub") Integer sub){

        List<schedule> schedules = teacherService.GroupFilter(group,sub);

        return schedules != null && !schedules.isEmpty()
                ? new ResponseEntity<>(schedules,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/teacher/{id}/lessons")
    public ResponseEntity<?> TeacherLessons(@PathVariable(name = "id") Integer id){
        Teacher teacher = teacherService.read(id);
        //List<String> teacherFioList = new ArrayList<>();
        List<Lessons> lessons = teacher.getLessons();

        return lessons != null && !lessons.isEmpty()
                ? new ResponseEntity<>(lessons,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

}
