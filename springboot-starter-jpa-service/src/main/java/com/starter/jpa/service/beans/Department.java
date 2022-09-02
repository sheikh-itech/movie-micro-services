package com.starter.jpa.service.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Department implements Serializable {

	@Id
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="department")
	//@SequenceGenerator(name="department", sequenceName="departmentSeq", allocationSize=1)
	private int deptid;
	private String deptName;
	private String deptType;
	
	@Override
	public String toString() {
		return "{deptid=" + deptid + ", deptName=" + deptName + ", deptType=" + deptType + "}";
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptType() {
		return deptType;
	}
	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}
}
