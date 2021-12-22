package id.oneindoensia.javabootcamp.day7.advancemapping.repository;

import id.oneindoensia.javabootcamp.day7.advancemapping.model.Instructor;
import id.oneindoensia.javabootcamp.day7.advancemapping.model.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {
}
