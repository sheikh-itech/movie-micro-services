package com.jpa.service.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.service.beans.Rating;
import com.jpa.service.repositories.RatingRepository;

@RestController
@RequestMapping("rating")
public class RatingResource {

	@Autowired 
	private RatingRepository ratingRepo;
	
	@RequestMapping("fetchAll")
	public Iterable<Rating> getAllRatings() {

		return ratingRepo.findAll();
	}
}
