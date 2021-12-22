package id.oneindoensia.javabootcamp.day7.advancemapping.service;

import id.oneindoensia.javabootcamp.day7.advancemapping.model.Course;
import id.oneindoensia.javabootcamp.day7.advancemapping.model.Instructor;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourses();
    Course findById(int id);
    void save(Course course);
    void deleteById(int id);
}
