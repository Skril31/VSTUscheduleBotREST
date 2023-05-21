package com.example.botsceduleapp.service.schedule;

import com.example.botsceduleapp.model.Schedule.Subjects;
import com.example.botsceduleapp.repository.schedule.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectsServiceImp implements SubjectsService{

    SubjectRepository subjectRepository;
    SubjectsServiceImp(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void create(Subjects subjects) {
        subjectRepository.save(subjects);
    }

    @Override
    public List<Subjects> readAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subjects read(int id) {
        Optional<Subjects> emp = subjectRepository.findById(id);
        if(emp.isPresent()){
            return emp.get();
        }
        return null;
    }

    @Override
    public boolean update(Subjects subjects, int id) {
        if (subjectRepository.existsById(id)){
            subjects.setId(id);
            subjectRepository.save(subjects);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (subjectRepository.existsById(id)){
            subjectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
