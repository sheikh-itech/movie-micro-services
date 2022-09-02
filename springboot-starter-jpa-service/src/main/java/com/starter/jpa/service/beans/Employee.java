package com.starter.jpa.service.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "Employees",
uniqueConstraints = @UniqueConstraint(name="uniqueColum", columnNames = {"mobile", "name"}))
@NamedQuery(name = "Employee.findBySalary",
query = "select e.name, e.mobile from Employee e where e.salary = ?1")
public class Employee {

	@Id
	@SequenceGenerator(name="employeeSeq", sequenceName="employeeSeq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employeeSeq")
	private int empId;
	private String name;
	private String empType;
	private float salary;
	@Column(name="mobile", nullable = false)
	private long mobile;
	@Embedded
	private Guardian guardian;
	
	@OneToOne//(targetEntity = Address.class, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "addr_id", referencedColumnName =  "id")
	private Address address;
	
	//@OneToMany(targetEntity = Performance.class, cascade = CascadeType.ALL)
	//@JoinColumn(name = "performnc_id", referencedColumnName =  "empId")
	//private List<Performance> performance;
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
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	/*
	 * public List<Performance> getPerformance() { return performance; } public void
	 * setPerformance(List<Performance> performance) { this.performance =
	 * performance; }
	 */
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
		//this.address = address;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Guardian getGuardian() {
		return guardian;
	}

	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}

	@Override
	public String toString() {
		return "{empId: " + empId + ", name: " + name + ", address: " /* + address */ + "}";
	}
}
