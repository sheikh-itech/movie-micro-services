package com.starter.jpa.service.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "Employees")
public class Employee implements Serializable {

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employees")
	@SequenceGenerator(name="employees", sequenceName="employeesSeq", allocationSize=1)
	private int empId;
	private String name;
	private String empType;
	private float salary;
	private long mobile;
	
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "addr_id", referencedColumnName =  "empId")
	private List<Address> address;
	
	@OneToMany(targetEntity = Performance.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "performnc_id", referencedColumnName =  "empId")
	private List<Performance> performance;
	/*
	@OneToMany(targetEntity = Department.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "departmnt_id", referencedColumnName =  "empId")
	private List<Department> department;
	
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	//@JoinColumn(foreignKey = @ForeignKey(name = "achievement_id"), name = "achievement_id")
	@OneToMany(targetEntity = Achievement.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "achievement_id", referencedColumnName =  "empId")
	private List<Achievement> achievement;
	*/
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
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public List<Performance> getPerformance() {
		return performance;
	}
	public void setPerformance(List<Performance> performance) {
		this.performance = performance;
	}
	/*
	public List<Department> getDepartment() {
		return department;
	}
	public void setDepartment(List<Department> department) {
		this.department = department;
	}
	public List<Achievement> getAchievement() {
		return achievement;
	}
	public void setAchievement(List<Achievement> achievement) {
		this.achievement = achievement;
	}
	*/
	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "{empId: " + empId + ", name: " + name + ", address: " + address + "}";
	}
}
