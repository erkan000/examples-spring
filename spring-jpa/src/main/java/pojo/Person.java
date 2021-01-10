package pojo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Pers", schema = "DBB")
public class Person {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private LocalDate birthDay;
	
	@Column(name = "act")
	private boolean active;
	private String city;
	
	@OneToMany(mappedBy = "personF", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<TelNumber> numberList;
	
	public Person() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<TelNumber> getNumberList() {
		return numberList;
	}

	public void setNumberList(List<TelNumber> numberList) {
		this.numberList = numberList;
	}
}
