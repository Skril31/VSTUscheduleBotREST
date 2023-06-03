package com.example.botsceduleapp.controller;

import com.example.botsceduleapp.model.Schedule.Lessons;

import com.example.botsceduleapp.service.schedule.LessonsService;
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
    @GetMapping(value = "/lessons/weekDay/{weekDay}/weekType/{weekType}/group/{group}/subgroup/{sub}")
    public ResponseEntity <?> WeekDayFilter(@PathVariable(name = "weekDay") String weekD, @PathVariable(name = "weekType") Integer weekT,@PathVariable(name = "group") String gr, @PathVariable(name = "sub") Integer sub){

        final List<Lessons> lessons = lessonsService.findLessonsByWeekDayAndWeekTypeAndGroupsGroupNameAndGroupsSubgroup(weekD,weekT,gr,sub);

        return lessons!=null && !lessons.isEmpty()
                ? new ResponseEntity<>(lessons,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/lessons/weekType/{weekType}/group/{group}")
    public ResponseEntity<List<Lessons>> WeekTypeFilter(@PathVariable(name = "weekType") Integer weekType, @PathVariable(name = "group") String group){
        final List<Lessons> lessons = lessonsService.findLessonsByWeekTypeAndGroupsGroupName(weekType, group);

        return lessons!=null && !lessons.isEmpty()
                ? new ResponseEntity<>(lessons,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
