package jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo.Person;
import rowmapper.PersonRowMapper;

@Repository
public class PersonRepositoryImpl implements PersonRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Person p) {
		return jdbcTemplate.update("insert into person (name, birthDay, active, city) values (?,?,?,?)", 
								p.getName(), p.getBirthDay(), p.isActive(), p.getCity());
	}
	
	@Override
	public int saveWithSimpleJdbc(Person ride) {
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		
		insert.setGeneratedKeyName("id");
		
		Map<String, Object> data = new HashMap<>();
		data.put("name", ride.getName());
		data.put("birthDay", ride.getBirthDay());
		
		List<String> columns = new ArrayList<>();
		columns.add("name");
		columns.add("birthDay");
		
		insert.setTableName("person");
		insert.setColumnNames(columns);
		Number key = insert.executeAndReturnKey(data);
		
		return key.intValue();
	}
	
	@Override
	public List<Person> getPersons() {
		return jdbcTemplate.query("Select * from person", new PersonRowMapper());
	}
	
	@Override
	public Person getPerson(int id) {
		return jdbcTemplate.queryForObject("Select * from person where id=?", new PersonRowMapper(), id);
	}
	
	@Override
	public int updatePersonCity(Person p) {
		return jdbcTemplate.update("update person set city = ? where id = ?", p.getCity(), p.getId());
	}
	
	@Override
	public void updatePersonCities(List<Object[]> params) {
		jdbcTemplate.batchUpdate("update person set city = ? where id = ?", params);
	}
	
	@Override
	public void rollBackTest() {
		jdbcTemplate.update("insert into person (name, birthDay, active, city) values ('E1', '2020-12-21', true, 'Ankara')");
		jdbcTemplate.update("insert into person (name, birthDay, active, city) values ('E2', '2020-11-02', true, 'Adana')");
		throw new RuntimeException("Error !!!");
	}
	
	@Override
	@Transactional
	public void rollBackTestTransactional() {
		jdbcTemplate.update("insert into person (name, birthDay, active, city) values ('E3', '2020-12-21', true, 'Isparta')");
		jdbcTemplate.update("insert into person (name, birthDay, active, city) values ('E4', '2020-11-02', true, 'Bursa')");
		throw new RuntimeException("Error !!!");
	}

}
