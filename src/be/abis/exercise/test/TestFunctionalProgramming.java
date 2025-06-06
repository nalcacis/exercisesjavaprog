package be.abis.exercise.test;

import be.abis.exercise.model.Person;
import be.abis.exercise.repository.MemoryPersonRepository;
import be.abis.exercise.repository.PersonRepository;

import java.util.List;
import java.util.function.Predicate;

public class TestFunctionalProgramming {

    public static void main(String[] args) {

        PersonRepository pr = new MemoryPersonRepository();
        List<Person> persons = pr.findAllPersons();

        System.out.println("All persons:");
        TestSomethingInterface tsi = s ->s.startsWith("S");
        for (Person p: persons){
            System.out.println(p);
            //System.out.println("Second Step");
            System.out.println(doTheTest(s -> s.startsWith("S"), p.getFirstName()));
            Predicate<String> myPredicate = s -> s.startsWith("S");
            boolean startsWithS = tsi.testSomething(p.getFirstName());
            System.out.println("FirstName starts with S:" + (startsWithS?"yes":"no"));
        }
    }
    public static boolean doTheTest(Predicate<String> tsi, String s){
        return tsi.test(s);
    }
}