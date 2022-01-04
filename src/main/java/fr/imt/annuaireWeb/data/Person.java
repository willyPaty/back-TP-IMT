package fr.imt.annuaireWeb.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String surname;
	private String phone;
	private String city;

	public Person() {
	};

	public Person(int id, String name, String surname, String phone, String city) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.city = city;
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
		this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname.substring(0, 1).toUpperCase() + surname.substring(1).toLowerCase();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	 @Override
	  public String toString() {
	    return String.format(
	        "Person[id=%d, Name='%s', Surname='%s', Phone='%s', City='%s']",
	        id, name, surname, phone, city);

	 }
}