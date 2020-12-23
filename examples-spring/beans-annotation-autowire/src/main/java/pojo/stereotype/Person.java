package pojo.stereotype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "customPersonName")
public class Person {

	@Value("32")
	private int id;
	
	@Value("Erkan")
	private String name;

	public Person() {
		System.out.println("*** Person Created: No-args const");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
