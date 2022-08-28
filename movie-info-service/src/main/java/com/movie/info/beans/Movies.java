package com.movie.info.beans;

import java.util.List;

public class Movies {

	private List<Movie> movies;
	
	public Movies() {	}
	public Movies(List<Movie> movies) {
		this.movies = movies;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
