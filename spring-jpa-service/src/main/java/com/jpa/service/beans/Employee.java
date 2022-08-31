package com.jpa.service.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	private String name;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "address_id"), name = "address_id")
	private List<Address> address;
	
	public Employee() {		}
	
	public Employee(String name, Address address) {
		super();
		this.address  = new ArrayList<Address>();
		this.name = name;
		this.address.add(address);
	}
	
	public int getEmpid() {
		return empId;
	}
	public void setEmpid(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address.add(address);
	}
	@Override
	public String toString() {
		return "{empId: " + empId + ", name: " + name + ", address: " + address + "}";
	}
}
