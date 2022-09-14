package repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.AppConfig;
import entity.Islem;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class ManyToOneTest {
	
	@Autowired
	private IslemRepository islemRepository;
	
	@Test
	public void test() {
		
		/**
		 * Bu testin amacı OneToMany ve ManyToOne ilişkilerde bir select yaparken tek sorgu ile (Join yaparak)
		 * alttaki nesneleri de çekmesini sağlamaktır. tek sorgu ile join yaparak çekmek
		 * Bunun 2 yolu var, query yazmak veya @EntityGraph tanımlamak
		 */
		
		Islem islem = islemRepository.findByName("test").get();
		assertNotNull(islem);
		assertNotNull(islem.getOdemeBaslik());
	}

}
