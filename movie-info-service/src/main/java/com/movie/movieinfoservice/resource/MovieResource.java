package com.movie.movieinfoservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@RequestMapping("{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") int movieId) {
		return new Movie(movieId,"Avengers","Movie on SuperHero");
	}

}
