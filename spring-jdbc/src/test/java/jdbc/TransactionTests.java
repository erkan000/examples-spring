package jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class TransactionTests {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void saveTest() {
		try {
			personRepository.rollBackTest();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		
		Person per = personRepository.getPerson(2);
		assertEquals("Adana", per.getCity());		
	}
	
	@Test
	public void saveTestTransactional() {
		try {
			personRepository.rollBackTestTransactional();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		
		List<Person> list = personRepository.getPersons();
		assertEquals(2, list.size());		
	}	

}
