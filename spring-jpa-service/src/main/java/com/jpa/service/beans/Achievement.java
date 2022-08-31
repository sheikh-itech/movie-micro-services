package com.jpa.service.beans;

public class Achievement {

	private String type;
	private String desc;
	private float weight;
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
	@Override
	public String toString() {
		return "Achievement{ type=" + type + ", desc=" + desc + ", weight=" + weight + " }";
	}
}
