package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Person;

@Repository
public interface TestJpaRepository extends JpaRepository<Person, Integer>, TestJpaRepositoryCustom {
	
	
}
