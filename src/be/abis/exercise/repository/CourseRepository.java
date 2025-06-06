package be.abis.exercise.repository;

import be.abis.exercise.model.Course;

import java.time.format.DateTimeFormatter;
import java.util.List;

public interface CourseRepository {

    List<Course> findAllCourses();
    void addCourse(Course c);
    public void printAllCourses();

    static String formatCourse(Course c) {
        StringBuilder sb = new StringBuilder("");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        sb.append(c.getTitle()).append(";")
                .append(c.getDays()).append(";")
                .append(c.getDailyPrice()).append(";")
                .append(c.getReleaseDate().format(dtf));
        return sb.toString();
    }


}
