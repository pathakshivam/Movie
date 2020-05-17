package com.movie.ratingdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.ratingdataservice.model.Rating;
import com.movie.ratingdataservice.model.UserRating;

@RestController
@RequestMapping("/movieRating")
public class MovieRatingResource {

	@RequestMapping("{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") int movieId) {
		return new Rating(movieId,4);
	}
	
	@RequestMapping("/user/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating(1,5),
				new Rating(2,8)
		);
		UserRating userRatings = new UserRating();
		userRatings.setUserRating(ratings);
		return userRatings;
	}
}
