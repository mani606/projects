package com.example.demo.bean;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")

public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="country")
	private String country;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(targetEntity = Hobby.class, cascade = { CascadeType.ALL })  
	@JoinTable(name = "hobbies",   
	            joinColumns = { @JoinColumn(name = "u_id") },   
	            inverseJoinColumns = { @JoinColumn(name = "id") })  
	private Set<Hobby> hobbies;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", country=" + country + ", name=" + name + ", hobbies=" + hobbies + "]";
	}  
	
	


	
	

}
