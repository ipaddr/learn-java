package id.oneindoensia.javabootcamp.day7.advancemapping.service;

import id.oneindoensia.javabootcamp.day7.advancemapping.model.Course;
import id.oneindoensia.javabootcamp.day7.advancemapping.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews();
    Review findById(int id);
    void save(Review review);
    void deleteById(int id);
}
