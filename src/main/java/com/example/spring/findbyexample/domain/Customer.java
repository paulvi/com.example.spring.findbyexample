package com.example.spring.findbyexample.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String address;
	
	private String country;
	
	public Customer(){}
	

	public Customer(String first, String last) {
		name = first+" "+last;
	}

	@Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', country='%s']",
                id, name, country);
    }
	
	//--- generated getters & setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	//---
	
}
