package com.starter.jpa.service.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@Entity
//@Table(name = "Achievement")
public class Achievement {

	//@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="achievement")
	//@SequenceGenerator(name="achievement", sequenceName="achievementSeq", allocationSize=1)
	private int id;
	private String type;
	private String desc;
	private float weight;
	
	public Achievement() {		}
	
	public Achievement(int id, String type, String desc, float weight) {
		super();
		this.id = id;
		this.type = type;
		this.desc = desc;
		this.weight = weight;
	}
	
	public Achievement(String type, String desc, float weight) {
		super();
		this.type = type;
		this.desc = desc;
		this.weight = weight;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Achievement{ type=" + type + ", desc=" + desc + ", weight=" + weight + " }";
	}
}
