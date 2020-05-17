package com.movie.moviecatalogsservice.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.movie.moviecatalogsservice.model.CatalogItem;
import com.movie.moviecatalogsservice.model.Movie;
import com.movie.moviecatalogsservice.model.Rating;
import com.movie.moviecatalogsservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResouce {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("{usedId}")
	public List<CatalogItem> getCatalog(@PathVariable("usedId") String userId) {
		
		
		List<CatalogItem> listOfCatalog = new ArrayList<CatalogItem>();
		CatalogItem cI = null;
		UserRating userRatings = restTemplate.getForObject("http://movie-info-service/movieRating/user/"+userId, UserRating.class);
		
		for(Rating r : userRatings.getUserRating()) {
			// JAVA UNMARSHALL MOVIE, so if there's no empty constructor it will raise error
			Movie movieInfo = restTemplate.getForObject("http://rating-data-info/movies/"+r.getMovieId(), Movie.class);
			cI = new CatalogItem(movieInfo.getMovieName(),movieInfo.getInfo(),r.getRating());
			listOfCatalog.add(cI);
		}
		
		return listOfCatalog;
	}
}
