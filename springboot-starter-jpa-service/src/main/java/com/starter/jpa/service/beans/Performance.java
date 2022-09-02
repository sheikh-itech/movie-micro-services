package com.starter.jpa.service.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@Entity
//@Table(name = "Performance")
public class Performance {

	//@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="performance")
	//@SequenceGenerator(name="performance", sequenceName="performanceSeq", allocationSize=1)
	private int id;
	private String type;
	private float grade;
	private float bonus;
	private String desc;
	
	public Performance() {		}
	
	public Performance(int id, String type, float grade, float bonus, String desc) {
		this.id = id;
		this.type = type;
		this.grade = grade;
		this.bonus = bonus;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "Performance{ type=" + type + ", grade=" + grade + ", bonus=" + bonus + ", desc=" + desc + " }";
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
