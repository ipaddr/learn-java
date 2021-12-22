package id.oneindoensia.javabootcamp.day7.advancemapping.service;

import id.oneindoensia.javabootcamp.day7.advancemapping.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findById(int id);
    void save(Student student);
    void deleteById(int id);
}
