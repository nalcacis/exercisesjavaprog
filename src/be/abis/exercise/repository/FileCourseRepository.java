package be.abis.exercise.repository;

import be.abis.exercise.model.Course;

import javax.imageio.stream.ImageInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileCourseRepository implements CourseRepository {

    CourseRepository cr = new MemoryCourseRepository();
    private List<Course> courses = new ArrayList<Course>();


    String filePath = "C:\\temp\\javacourses\\courses.csv";

    public static  Course parseCourse(String s){
        String[] parts = s.split(";");
        String title = parts[0];
        int days = Integer.parseInt(parts[1]);
        double priceWithVat = Double.parseDouble(parts[2]);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate released = LocalDate.parse(parts[3],dtf);
        Course c = new Course(title, days, priceWithVat, released);
        return c;
    }

    public FileCourseRepository() throws IOException {
        this.readFile();
    }

    public void readFile() throws IOException {
        try {
            BufferedReader bf =  new BufferedReader(new FileReader(filePath));{
            String line;
            while ((line = bf.readLine()) != null) {
                Course course = parseCourse(line);
                courses.add(course);
                        }
                    }
            }catch (IOException e){
            System.out.println(e.getMessage());
                }
    }


    @Override
    public List<Course> findAllCourses() {
        return List.of();
    }

    @Override
    public void addCourse(Course c) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
            bw.newLine();
            bw.write(CourseRepository.formatCourse(c));
            courses.add(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printAllCourses() {

    }
}