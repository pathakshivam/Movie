package com.movie.movieinfoservice.model;

public class Movie {
	private int movieId;
	private String movieName;
	private String info;

	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Movie(int movieId, String movieName, String info) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.info = info;
	}
	public Movie(int movieId, String info) {
		super();
		this.movieId = movieId;
		this.info = info;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
