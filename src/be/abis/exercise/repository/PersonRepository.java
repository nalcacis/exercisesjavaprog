package be.abis.exercise.repository;

import be.abis.exercise.model.Person;

import java.util.List;

public interface PersonRepository {

	List<Person> findAllPersons();
	Person findPersonById(int id);
	Person findPersonByEmailAndPassword(String email, String password);
	List<Person> findPersonsForCompany(String companyName);
	void addPerson(Person p);
}
