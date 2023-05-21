package com.example.botsceduleapp.controller;

import com.example.botsceduleapp.model.Schedule.Lessons;
import com.example.botsceduleapp.model.Schedule.Teacher;
import com.example.botsceduleapp.service.schedule.LessonsService;
import com.example.botsceduleapp.service.schedule.LessonsServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonsController {

    private final LessonsService lessonsService;

    public LessonsController(LessonsService lessonsService){
        this.lessonsService = lessonsService;
    }

    @PostMapping(value = "/lessons")
    public ResponseEntity<?> create(@RequestBody Lessons lessons){
        lessonsService.create(lessons);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/lessons")
    public ResponseEntity<List<Lessons>> readAll(){
        final List<Lessons> lessons = lessonsService.readAll();

        return lessons != null && !lessons.isEmpty()
                ? new ResponseEntity<>(lessons,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/lessons/{id}")
    public ResponseEntity<Lessons> read(@PathVariable(name = "id") int id){
        final Lessons lessons = lessonsService.read(id);

        return lessons != null
                ? new ResponseEntity<>(lessons,HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/lessons/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id,@RequestBody Lessons lessons){
        final boolean updated = lessonsService.update(lessons,id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/lessons/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean deleted = lessonsService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/teachers/{name}/lessons")
    public ResponseEntity<List<Lessons>> TeacherFilter(@PathVariable(name = "name") String fio){

        final List<Lessons> lessons = lessonsService.findLessonsByTeacher(fio);

        return lessons!=null && !lessons.isEmpty()
                ? new ResponseEntity<>(lessons,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
