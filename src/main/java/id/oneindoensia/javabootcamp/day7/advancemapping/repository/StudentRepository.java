package id.oneindoensia.javabootcamp.day7.advancemapping.repository;

import id.oneindoensia.javabootcamp.day7.advancemapping.model.Course;
import id.oneindoensia.javabootcamp.day7.advancemapping.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
