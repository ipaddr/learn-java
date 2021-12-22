package id.oneindoensia.javabootcamp.day7.advancemapping.repository;

import id.oneindoensia.javabootcamp.day7.advancemapping.model.Instructor;
import id.oneindoensia.javabootcamp.day7.advancemapping.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
