package rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pojo.Person;

public class PersonRowMapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person p = new Person();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setBirthDay(rs.getDate("birthDay").toLocalDate());
		p.setCity(rs.getString("city"));
		p.setActive(rs.getBoolean("active"));
		return p;
	}

}
