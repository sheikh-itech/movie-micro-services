package com.jpa.service.beans;

public class Performance {

	private String type;
	private float grade;
	private float bonus;
	private String desc;
	
	@Override
	public String toString() {
		return "Performance{ type=" + type + ", grade=" + grade + ", bonus=" + bonus + ", desc=" + desc + " }";
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
