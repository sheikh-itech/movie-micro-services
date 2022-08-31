package com.jpa.service.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String type;
	private String landmark;
	private String address;
	private int zipcode;
	
	public Address() {		}
	
	public Address(String type, String landmark, String address, int zipcode) {
		super();
		this.type = type;
		this.landmark = landmark;
		this.address = address;
		this.zipcode = zipcode;
	}
	
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "{type: "+type+", landmark: " + landmark + ", address: " + address + ", zipcode: " + zipcode + "}";
	}
}
