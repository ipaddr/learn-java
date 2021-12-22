package id.oneindoensia.javabootcamp.day7.advancemapping.main;

import id.oneindoensia.javabootcamp.day7.advancemapping.model.*;
import id.oneindoensia.javabootcamp.day7.advancemapping.service.CourseService;
import id.oneindoensia.javabootcamp.day7.advancemapping.service.InstructorService;
import id.oneindoensia.javabootcamp.day7.advancemapping.service.ReviewService;
import id.oneindoensia.javabootcamp.day7.advancemapping.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/courses")
public class MainMapping {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/test")
    @Transactional
    public String main() {
        testOnetoOne();
        testOneToMany();
        testManyToMany();
        return "sayhello";
    }

    private void testOnetoOne(){
        Instructor instructor = new Instructor();
        instructor.setFirstName("iip");
        instructor.setLastName("permana");
        instructor.setEmail("iip.permana@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setYoutubeChannel("www.youtube.com/iip");
        instructorDetail.setHobby("lari");

        instructorDetail.setInstructor(instructor);
        instructor.setInstructorDetail(instructorDetail);

        instructorService.save(instructor);
    }

    @Transactional
    private void  testOneToMany(){
        // create some courses
        Course tempCourse1 = courseService.findById(2);
        Course tempCourse2 = courseService.findById(3);


        // add some reviews
        Review review =  new Review("Great course ... loved it!");
        Review review2 =  new Review("Cool course, job well done");
        Review review3 =  new Review("What a dumb course, you are an idiot!");
        Review review4 =  new Review("No comment!");

        tempCourse1.getReviews().addAll(Arrays.asList(review, review2));
        tempCourse2.getReviews().addAll(Arrays.asList(review3, review4));

        review.setCourse(tempCourse1);
        review2.setCourse(tempCourse1);
        review3.setCourse(tempCourse2);
        review4.setCourse(tempCourse2);

        courseService.save(tempCourse1);
        courseService.save(tempCourse1);
    }

    @Transactional
    private void testManyToMany(){
        Course tempCourse = courseService.findById(6);
        Course tempCourse2 = courseService.findById(7);

        // create the students
        Student tempStudent1 = new Student("Bono", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");

        studentService.save(tempStudent1);
        studentService.save(tempStudent2);

        // save student courses
        tempStudent1.getCourses().addAll(Arrays.asList(tempCourse, tempCourse2));
        studentService.save(tempStudent1);

        // save course students
        tempCourse.getStudents().addAll(Arrays.asList(tempStudent1, tempStudent2));
        courseService.save(tempCourse);
    }
}
