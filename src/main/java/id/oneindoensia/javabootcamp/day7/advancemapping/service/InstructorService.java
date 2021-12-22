package id.oneindoensia.javabootcamp.day7.advancemapping.service;

import id.oneindoensia.javabootcamp.day7.advancemapping.model.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> findAllInstructors();
    Instructor findById(int id);
    void save(Instructor instructor);
    void deleteById(int id);
}
