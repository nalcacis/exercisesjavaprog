package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import be.abis.exercise.repository.*;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PersonStreamTest {
    public static void main(String[] args) {

        PersonRepository pr = new MemoryPersonRepository();
        List<Person> persons = pr.findAllPersons();
        pr.findAllPersons();

        System.out.println("\n---------------------------All persons:--------------------------------------------------");
        persons.forEach(System.out::println);

        System.out.println("\n-----------------------------Surnames with S---------------------------------------------");
        persons.stream().filter(person -> person.getLastName().startsWith("S"))
                .forEach(System.out::println);

        System.out.println("\n-----------------------------Older than 40----------------------------------------------");
        persons.stream().filter(person -> person.calculateAge()>40)
                .forEach(System.out::println);

        System.out.println("\n------------------------Older than 40 and Surname starts with S--------------------------");
        persons.stream().filter(person -> person.getLastName().startsWith("S"))
                .filter(person -> person.calculateAge()>40)
                .forEach(System.out::println);

        System.out.println("\n--------------------------Sorted---------------------------------------------------------");
        persons.stream().sorted((p1, p2) -> p1.getLastName().compareTo(p2.getLastName())).forEach(System.out::println);

        System.out.println("\n-------------------------Working in Leuven-----------------------------------------------");
        persons.stream()
                .filter(person -> person.getCompany() != null)
                .filter(person -> "Leuven".equals(person.getCompany().getAddress().getTown()))
                .sorted(Comparator.comparing(Person::calculateAge))
                .forEach(System.out::println);

        //Commented because it is not the expected solution
        /*System.out.println("\n-----------------------Printing the company names of all persons-------------------------");
        persons.forEach(person -> {
            String companyName= "Unemployed";
            if (person.getCompany() !=null){
                companyName=person.getCompany().getName();
            }
            System.out.println(person.getFirstName() + " works at " + companyName);
        })*/

        System.out.println("\n-----------------------Printing the company names of all persons-------------------------");
        persons.stream()
                .filter(person -> person.getCompany() != null)
                .map(person -> person.getCompany().getName())
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n-----------------------Step 7-------------------------");
        System.out.println("\n-----------------------Find all people-------------------------");
        try {
            System.out.println("People found");
            System.out.println(pr.findAllPersons());
        }catch (PersonNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n-----------------------Find Person by ID-------------------------");
        try {
            System.out.println("Person found by ID:");
            System.out.println(pr.findPersonById(3));
        }catch  (PersonNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n-------------Find Person by email and Password-------------------");
        try {
            System.out.println("Person found by email and password:");
            System.out.println(pr.findPersonByEmailAndPassword("gindesteege@abis.be", "somepass3"));
        }catch  (PersonNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n-------------Find Person by company-------------------");
        try {
            System.out.println("Person found by company:");
            System.out.println(pr.findPersonsForCompany("ABIS"));
        }catch  (PersonNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
        try {
            System.out.println("\n---------------Add Existing Person with all details------------------");
            Person p = new Person("Koen", "De Backer", LocalDate.of(1962, 11, 25), "kdebacker@abis.be", "somepass2", "nl");
            pr.addPerson(p);
        } catch (PersonAlreadyExistException e){
            System.out.println(e.getMessage());
        }
        persons.stream().forEach(System.out::println);
    }
}