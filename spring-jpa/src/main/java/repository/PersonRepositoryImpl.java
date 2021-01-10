package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import pojo.Person;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Person p){
		em.persist(p);
		em.flush();
	}
	
	@Override
	public List<Person> getAllPerson(){
		TypedQuery<Person> q = em.createQuery("Select p from Person p", Person.class);
		return q.getResultList();
	}

	@Override
	public Person getPerson(long id) {
		Person p = em.find(Person.class,id);
		return p;
	}

}
