package id.oneindoensia.javabootcamp.day7.advancemapping.service;

import id.oneindoensia.javabootcamp.day7.advancemapping.model.Instructor;
import id.oneindoensia.javabootcamp.day7.advancemapping.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public List<Instructor> findAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor findById(int id) {
        return instructorRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void save(Instructor instructor){
        instructorRepository.save(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        instructorRepository.deleteById(id);
    }
}
