package com.movie.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.catalog.beans.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieRatingService {

	@Autowired
	private RestTemplate template;
	
	@HystrixCommand(fallbackMethod = "getFallbackRatingInfo")
	public Rating getRatingInfo(int id) {
		
		Rating rating = template.getForObject("http://movie-rating-service/movie-rating/find?id="+id, Rating.class);
		
		return rating;
	}
	
	public Rating getFallbackRatingInfo(int id) {
		
		Rating rating = new Rating(0, "Dummy", 0.0f, "Dummy Desc");
		
		return rating;
	}
}
