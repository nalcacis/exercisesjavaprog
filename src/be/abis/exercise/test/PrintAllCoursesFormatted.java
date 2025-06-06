package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;

import java.util.List;

public class PrintAllCoursesFormatted {
    public static void main(String[] args) {
        CourseRepository cr = new MemoryCourseRepository();
        List<Course> courses = cr.findAllCourses();
        cr.printAllCourses();
    }
}