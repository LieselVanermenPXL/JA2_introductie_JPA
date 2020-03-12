package be.pxl.ja2.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   // hierdoor weet Hibernate dat deze objecten opgeslaan kunnen worden in de databank
@Table(name = "contacts")  // om Hibernate te laten weten dat objecten van deze klasse in de tabel opgeslaan zitten als "contacts"
public class Contact {
	@Id    // laat weten wat de private key is
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // door IDENTITY weet Hibernate dat Id vanzelf wordt opgehoogd door de databank (Auto increment)
	private int id;
	private String name;
	private int phone;
	private String email;

	public Contact() {       // default constructor moet ALTIJD aanwezig zijn --> Hibernate heeft deze nodig om objecten aan te maken
	}

	public Contact(String name, int phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact{" +
				"id=" + id +
				", name='" + name + '\'' +
				", phone=" + phone +
				", email='" + email + '\'' +
				'}';
	}
}
