package jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;
import pojo.Person;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class CrudTests {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void saveTest() {
		int affRows = personRepository.save(getPerson());
		assertEquals(1, affRows);
	}
	
	@Test
	public void saveWithSimpleJdbcInsertTest() {
		int identityCol = personRepository.saveWithSimpleJdbc(getPerson());
		assertEquals(2, identityCol);
	}
	
	@Test
	public void getPersonList() {
		List<Person> list = personRepository.getPersons();
		assertEquals(2, list.size());
	}
	
	@Test
	public void getPersonById() {
		Person per = personRepository.getPerson(1);
		assertEquals("Erkan", per.getName());
	}
	
	@Test
	public void updatePersonCity() {		
		Person p = getPerson();
		p.setId(2);
		p.setCity("Isparta");
		int affRows = personRepository.updatePersonCity(p);
		assertEquals(1, affRows);
		
		Person per = personRepository.getPerson(2);
		assertEquals("Isparta", per.getCity());
	}
	
	@Test
	public void updatePersonCityBatch() {		
		List<Object[]> params = new ArrayList<Object[]>();
		params.add(new Object[] {"İstanbul",1});
		params.add(new Object[] {"İzmir",2});
		personRepository.updatePersonCities(params);

		Person per = personRepository.getPerson(1);
		assertEquals("İstanbul", per.getCity());
		
		Person per2 = personRepository.getPerson(2);
		assertEquals("İzmir", per2.getCity());
	}
	
	
	private Person getPerson() {
		Person person = new Person();
		person.setName("Erkan");
		person.setBirthDay(LocalDate.now());
		person.setCity("Ankara");
		person.setActive(true);
		return person;
	}
}
