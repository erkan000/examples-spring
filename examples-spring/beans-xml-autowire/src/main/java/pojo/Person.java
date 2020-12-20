package pojo;

public class Person {

	private int id;
	private String name;

	public void print() {
		System.out.println("This is Person, named:\"" + name + "\", ID is :" + id);
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
