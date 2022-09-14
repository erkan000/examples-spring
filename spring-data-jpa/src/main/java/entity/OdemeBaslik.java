package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OdemeBaslik {

	@Id
	private int id;
	private String baslik;
	
	
	public OdemeBaslik() {
	}
	
	public OdemeBaslik(int id, String baslik) {
		this.id= id;
		this.setBaslik(baslik);
	}

	public String getBaslik() {
		return baslik;
	}

	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}

}
