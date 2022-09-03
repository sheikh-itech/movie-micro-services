package com.movie.rating.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starter.jpa.service.services.RatingService;
import com.movie.rating.beans.Rating;
import com.movie.rating.repositories.MovieRatingRepository;

@RestController
public class MovieRatingResource {

	@Autowired
	private RatingService ratingService;
	@Autowired
	private MovieRatingRepository movieCatalogRepo;
	private boolean flag = true;
	
	@RequestMapping(value="find", method = RequestMethod.GET)
	public ResponseEntity<Rating> getRating(@PathParam("id") int id) {
		
		if(flag) {
			
			//movieCatalog.saveAll(init());
			List<Rating> rtngs = init();
			List<com.starter.jpa.service.beans.Rating> ratings = new ArrayList<>();
			
			rtngs.forEach(item->ratings.add(new com.starter.jpa.service.beans.Rating(
					item.getId(), item.getName(), item.getRating(), item.getRatingDesc())));
			
			ratingService.saveAll(ratings);
			flag = false;
		}
		//To Check Hystrix Work
		try {
			//Thread.currentThread().wait(4000);
		}catch(Exception e) {}
		Rating rating = null;
		
		Optional<Rating> list = movieCatalogRepo.findById(id);
		if(list.isPresent())
			rating = list.get();
		
		return new ResponseEntity<Rating>(rating, HttpStatus.FOUND);
	}
	
	@RequestMapping(value="rating", method = RequestMethod.GET)
	public ResponseEntity<List<Rating>> getMoviess() {
		
		return new ResponseEntity<List<Rating>>(movieCatalogRepo.findAll(), HttpStatus.FOUND);
	}
	
	private List<Rating> init() {
		
		List<Rating> items = new ArrayList<>();
		
		items.add(new Rating(1, "Tiger", 7.2f, "Average movie"));
		items.add(new Rating(2, "Ek Tha Tiger", 8.5f, "Very Good movie"));
		items.add(new Rating(3, "Tiger Jinda Hai", 8.0f, "Good movie"));
		items.add(new Rating(4, "Chennai Express", 7.5f, "Romantically good movie"));
		items.add(new Rating(5, "Bahubali", 9.0f, "Technically very good movie"));
		
		return items;
	}
}
