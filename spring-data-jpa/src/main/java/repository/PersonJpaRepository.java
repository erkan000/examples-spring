package repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.Person;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Integer> {
	
	public List<Person> findByCityStartingWith(String city);
	
	public List<Person> findByBirthDayAfter(LocalDate date);
	
	public List<Person> findByActiveTrue();
	
	public List<Person> findByCityIsNull();
	
	public List<Person> findByCityIn(Collection<String> list);
	
	public List<Person> findTop3ByCityLikeOrderByNameAsc(String city);
	
	@Query("select p from Person p where p.birthDay between :start and :finish and p.active = :act")
	public List<Person> queryByBirthDayAndActive(@Param("start") LocalDate s1,
											 @Param("finish") LocalDate s2,
											 @Param("act") boolean active);
	
	@Query(value = "select * from Person where name = ?1", nativeQuery = true)
	public List<Person> queryByName(String name);
	
	@Modifying
	@Query("update Person p set p.name = ?1 where p.id=2")
	public int updateByName(String name);

	List<Person> namedFindPeopleByName(@Param("name") String type);
	
	@Query(name="Person.namedFindPeopleByName")
	List<Person> namedFindAllModelsByType(@Param("name") String type);
}
