package repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;
import entity.Person;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class QueryAnnTest {
	
	@Autowired
	private PersonJpaRepository personJpaRepository;
	
	@Test
	public void t11() {
		List<Person> list = personJpaRepository.queryByBirthDayAndActive(LocalDate.parse("1983-01-01"), LocalDate.parse("1984-01-01"), true);
		assertNotNull(list);
		assertEquals(1, list.size());
	}
	
	@Test
	@Transactional
	public void t12() {
		int affectedRows = personJpaRepository.updateByName("Erkan");
		assertEquals(1, affectedRows);
	}
	
	@Test
	public void t13() {
		List<Person> list = personJpaRepository.queryByName("Erkan");
		assertNotNull(list);
		assertEquals(1, list.size());
	}
	
	@Test
	public void t14() {
		// same metods
		List<Person> list = personJpaRepository.namedFindPeopleByName("Kaan");
		assertNotNull(list);
		assertEquals(1, list.size());
		
		List<Person> list2 = personJpaRepository.namedFindAllModelsByType("Kaan");
		assertNotNull(list2);
		assertEquals(1, list2.size());
	}

}
