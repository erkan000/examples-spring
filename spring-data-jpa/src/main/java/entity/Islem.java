package entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Islem {

	@Id
	private int id;
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(columnDefinition = "odeme_baslik_id")
	private OdemeBaslik odemeBaslik;
	
	public Islem() {
	}
	
	public Islem(int id, String name) {
		this.id= id;
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OdemeBaslik getOdemeBaslik() {
		return odemeBaslik;
	}

	public void setOdemeBaslik(OdemeBaslik odemeBaslik) {
		this.odemeBaslik = odemeBaslik;
	}

}
