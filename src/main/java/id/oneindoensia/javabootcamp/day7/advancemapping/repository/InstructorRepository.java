package id.oneindoensia.javabootcamp.day7.advancemapping.repository;

import id.oneindoensia.javabootcamp.day7.advancemapping.model.Course;
import id.oneindoensia.javabootcamp.day7.advancemapping.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
