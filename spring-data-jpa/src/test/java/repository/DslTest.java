package repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;
import entity.Person;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class DslTest {
	
	@Autowired
	private PersonJpaRepository personJpaRepository;
	
	@Test
	public void t11() {
		List<Person> list = personJpaRepository.findByCityStartingWith("İ");
		assertNotNull(list);
		assertEquals(2, list.size());
	}
	@Test
	public void t12() {
		List<Person> list = personJpaRepository.findByBirthDayAfter(LocalDate.parse("1984-01-01"));
		assertNotNull(list);
		assertEquals(3, list.size());
	}
	@Test
	public void t13() {
		List<Person> list = personJpaRepository.findByActiveTrue();
		assertNotNull(list);
		assertEquals(5, list.size());
	}
	@Test
	public void t14() {
		List<Person> list = personJpaRepository.findByCityIsNull();
		assertNotNull(list);
		assertEquals(1, list.size());
	}
	@Test
	public void t15() {
		Collection<String> cities = Arrays.asList("Ankara", "İzmir");
		List<Person> list = personJpaRepository.findByCityIn(cities);
		assertNotNull(list);
		assertEquals(2, list.size());
	}
	@Test
	public void t16() {
		List<Person> list = personJpaRepository.findTop3ByCityLikeOrderByNameAsc("%ta%");
		assertNotNull(list);
		assertEquals(3, list.size());
	}

}
