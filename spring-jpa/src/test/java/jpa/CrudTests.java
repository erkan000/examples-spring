package jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;
import pojo.Person;
import pojo.TelNumber;
import service.PersonService;
import service.TelNumberService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class CrudTests {
	
	@Autowired
	private PersonService personService;
	@Autowired
	private TelNumberService telService;
	
	@Test
	public void ashouldSavePerson() {
		personService.save(createPersonAndTelNumber());
	}
	
	@Test
	public void shouldGetPerson() {
		Person per = personService.getPerson(1);
		assertEquals("Erkan", per.getName());
		assertEquals("Ankara", per.getCity());
		assertEquals(true, per.isActive());
		assertEquals(LocalDate.parse("1984-01-01"), per.getBirthDay());
	}
	
	@Test
	public void shouldGetPersonTelNumbers() {
		List<Person> list = personService.getAllPerson();
		assertNotNull(list);
		assertEquals(3, list.get(0).getNumberList().size());
	}
	
	@Test
	public void shouldGetPersonFromTelNumber() {
		TelNumber tel = telService.getPersonNumber("555");		
		assertEquals("555", tel.getNumber());
		assertNotNull(tel.getPersonF());
		assertEquals("Erkan", tel.getPersonF().getName());
	}	
	
	@Test
	public void shouldRollBack() {
		TelNumber tel = telService.getPersonNumber("555");
		tel.setNumber("999");
		try {
			telService.batchJob(tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		TelNumber tel2 = telService.getPersonNumber("555");
		assertNotNull(tel2);
		assertEquals("555", tel2.getNumber());
		
	}	
	
	private Person createPersonAndTelNumber() {
		Person p = new Person();
		p.setName("Erkan");
		p.setCity("Ankara");
		p.setActive(true);
		p.setBirthDay(LocalDate.parse("1984-01-01"));
		List<TelNumber> numberList = new ArrayList<TelNumber>();
		numberList.add(new TelNumber("123", p));
		numberList.add(new TelNumber("555", p));
		numberList.add(new TelNumber("999", p));
		p.setNumberList(numberList );
		return p;
	}
}
