package be.abis.exercise.repository;

import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryPersonRepository implements PersonRepository {

    static Logger exceptionLogger = LogManager.getLogger("exceptionLogger");
    static Logger infoLogger = LogManager.getRootLogger();

    private List<Person> persons = new ArrayList<Person>();

    public MemoryPersonRepository()  {
        Person.counter=0;
        Address a1 = new Address("Diestsevest","32/4b","3000","Leuven","België","BE");
        Address a2 = new Address("Sint-Lazaruslaan","10","1210","Saint-Josse-Ten-Noode","Belgique","BE");
        Address a3 = new Address("Avenue du Bourget","42","1130","Brussels","Belgium","BE");
        Address a4 = new Address("Amsterdamseweg","55","1182GP","Amstelveen","Nederland","NL");

        Company c1 = new Company("ABIS",a1);
        Company c2 = new Company("BNP Paribas Fortis",a2);
        Company c3 = new Company("IBM",a3);
        Company c4 = new Company("KLM",a4);

        Person inst1 = new Person("Sandy", "Schillebeeckx", LocalDate.of(1978, 4, 10),"sschillebeeckx@abis.be","somepass1","nl", c1);
        Person inst2 = new Person("Koen", "De Backer",LocalDate.of(1962, 11, 25),"kdebacker@abis.be","somepass2","nl", c1);
        Person inst3 = new Person("Gie", "Indesteege",LocalDate.of(1958, 8, 19),"gindesteege@abis.be","somepass3","nl", c1);
        Person inst4 = new Person("Bart", "Lemarcq",LocalDate.of(1976, 2, 12),"blemarcq@abis.be","somepass4","fr", c1);
        Person p1 = new Person("Michel","Dupont",LocalDate.of(1980, 5, 5),"michel.dupont@bnpparibasfortis.com","somepass5","fr",c2);
        Person p2 = new Person("Anne","Van der Meulen",LocalDate.of(1984, 9, 30),"anne.vandermeulen@bnpparibasfortis.com","somepass6","nl",c2);
        Person p3 = new Person("Bob","Miles",LocalDate.of(1967, 3, 11),"bob.miles@ibm.com","somepass7","en",c3);
        Person p4 = new Person("Willem-Alexander","Janssen",LocalDate.of(1971, 1, 18),"willemalexander.janssen@klm.nl","somepass8","nl",c4);
        Person p5 = new Person("Jef","Smits",LocalDate.of(1988, 10, 10),"jefke@yahoo.com","somepass9","nl");

        persons.addAll(Arrays.asList(new Person[]{inst1,inst2,inst3,inst4,p1,p2,p3,p4,p5}));
    }


    @Override
    public List<Person> findAllPersons() {

        return persons;
    }

    @Override
    public Person findPersonById(int id) throws  PersonNotFoundException {
        return persons.stream()
                .filter(person -> person.getPersonNumber()==id)
                .findFirst()
                .orElseThrow(()->new PersonNotFoundException("Person with id" + id));
    }

    @Override
    public Person findPersonByEmailAndPassword(String email, String password) {
        return persons.stream()
                .filter(person -> email.equals(person.getEmail()))
                .filter(person -> password.equals(person.getPassword()))
                .findFirst()
                .orElseThrow(() -> new PersonNotFoundException("email: " + email + "Password: " + password));
    }

    @Override
    public List<Person> findPersonsForCompany(String companyName) {
        List <Person> foundPersons = persons.stream()
                .filter(person -> person.getCompany() !=null)
                .filter(person -> companyName.equals(person.getCompany().getName()))
                .collect(Collectors.toList());
                if(foundPersons.isEmpty()) throw new PersonNotFoundException("No person found for: + ");
                    return foundPersons;
    }

    @Override
    public void addPerson(Person p) throws PersonAlreadyExistException{
        if(!persons.contains(p)){
            persons.add(p);
            System.out.println(p + " new user added");
        }else throw new PersonAlreadyExistException("Person already exist on the list");
    }
}