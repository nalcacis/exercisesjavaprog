package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class CourseStreamTest {
    public static void main(String[] args) {

        Course course = new Course("DB2, an overview",5,550.0, LocalDate.of(1986, 4 , 30));
        String s = CourseRepository.formatCourse(course);
        System.out.println(s+"\n");

        CourseRepository cr = new MemoryCourseRepository();
        List<Course> courses = cr.findAllCourses();
        cr.findAllCourses();

        System.out.println("\n----------------------Step6---------------------------");
        System.out.println("\nCourse sorted on number of days and prices: ");
        courses.stream()
                .sorted(Comparator.comparing(Course::getDays)
                        .thenComparing(Course::getDailyPrice))
                .forEach(System.out::println);
    }
}