package repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class CustomRepoTest {
	
	@Autowired
	private TestJpaRepository testJpaRepository;
	
	@Test
	public void t11() {
		testJpaRepository.customMethod();
	}
	

}
