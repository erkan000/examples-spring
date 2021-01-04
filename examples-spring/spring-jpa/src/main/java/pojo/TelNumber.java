package pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Tel", schema = "DBB")
@NamedQueries({ @NamedQuery(name = TelNumber.GEL_ALL_NUMBERS, query = "select t from TelNumber t") })
public class TelNumber {

	public static final String GEL_ALL_NUMBERS = "getAll";
	
	@Id
	@GeneratedValue
	private long id;
	private String number;
	
	@ManyToOne
	private Person personF;	
	
	public TelNumber() {
	}

	public TelNumber(String number, Person p) {
		this.number = number;
		this.personF = p;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPersonF() {
		return personF;
	}

	public void setPersonF(Person personF) {
		this.personF = personF;
	}
	
}
