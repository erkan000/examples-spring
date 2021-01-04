package repository;

import java.util.List;

import pojo.Person;

public interface PersonRepository {

	void save(Person p);

	List<Person> getAllPerson();

	Person getPerson(long id);

}