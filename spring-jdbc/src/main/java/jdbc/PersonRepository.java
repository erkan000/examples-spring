package jdbc;

import java.util.List;

import pojo.Person;

public interface PersonRepository {
	
	int save(Person person);
	
	int saveWithSimpleJdbc(Person person);
	
	List<Person> getPersons();
	
	Person getPerson(int id);
	
	int updatePersonCity(Person p);
	
	void updatePersonCities(List<Object[]> params);
	
	void rollBackTest();

	void rollBackTestTransactional();

}
