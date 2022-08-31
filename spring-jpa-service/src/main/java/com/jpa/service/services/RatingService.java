package com.jpa.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.service.beans.Rating;
import com.jpa.service.repositories.RatingRepository;

@Service
public class RatingService {

	@Autowired 
	private RatingRepository ratingRepo;
	
	public void saveAll(List<Rating> ratings) {
		ratingRepo.saveAll(ratings);
	}
}
