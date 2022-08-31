package com.jpa.service.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private float rating;
	private String ratingDesc;
	
	public Rating() {	}
	
	public Rating(int id, String name, float rating, String ratingDesc) {
		this.id = id;
		this.name = name;
		this.ratingDesc = ratingDesc;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getRatingDesc() {
		return ratingDesc;
	}

	public void setRatingDesc(String ratingDesc) {
		this.ratingDesc = ratingDesc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
