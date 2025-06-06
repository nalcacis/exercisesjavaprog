package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.FileCourseRepository;

import java.io.IOException;
import java.time.LocalDate;

public class TestFileCourseRepository {
    public static void main(String[] args) {
        CourseRepository cr = null;
        try{
            cr  = new FileCourseRepository();
            cr.findAllCourses().forEach(System.out::println);

            Course c = new Course("Second Injected Course", 10, 100, LocalDate.of(2025,5,5));
            cr.addCourse(c);
            System.out.println("Course injection is successful");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}