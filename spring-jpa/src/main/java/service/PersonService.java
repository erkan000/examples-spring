package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Person;
import repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepo;
	
	@Transactional
	public void save(Person p){
		personRepo.save(p);
	}

	public List<Person> getAllPerson(){
		return personRepo.getAllPerson();
	}

	public Person getPerson(long id) {
		return personRepo.getPerson(id);
	}
}
