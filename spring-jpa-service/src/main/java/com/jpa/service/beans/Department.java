package com.jpa.service.beans;

public class Department {

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
