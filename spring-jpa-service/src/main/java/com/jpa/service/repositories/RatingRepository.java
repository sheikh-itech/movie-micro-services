package com.jpa.service.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpa.service.beans.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer> {

}
