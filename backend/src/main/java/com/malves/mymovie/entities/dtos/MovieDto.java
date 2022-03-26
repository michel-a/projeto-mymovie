package com.malves.mymovie.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.malves.mymovie.entities.Movie;

public class MovieDto {
	
	private Integer id;
	
	@NotBlank
	private String translatedTitle;
	private String originalTitle;
	
	//@NotEmpty
	private LocalDate releaseYear;
	private String genre;
	private String audio;
	private Float size;
	private Short duration;
	
	public MovieDto() {}
	
	public MovieDto(Movie movie) {
		this.id = movie.getId();
		this.translatedTitle = movie.getTranslatedTitle();
		this.originalTitle = movie.getOriginalTitle();
		this.releaseYear = movie.getReleaseYear();
		this.genre = movie.getGenre();
		this.audio = movie.getAudio();
		this.size = movie.getSize();
		this.duration = movie.getDuration();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTranslatedTitle() {
		return translatedTitle;
	}
	
	public void setTranslatedTitle(String translatedTitle) {
		this.translatedTitle = translatedTitle;
	}
	
	public String getOriginalTitle() {
		return originalTitle;
	}
	
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	
	public LocalDate getReleaseYear() {
		return releaseYear;
	}
	
	public void setReleaseYear(LocalDate releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getAudio() {
		return audio;
	}
	
	public void setAudio(String audio) {
		this.audio = audio;
	}
	
	public Float getSize() {
		return size;
	}
	
	public void setSize(Float size) {
		this.size = size;
	}
	
	public Short getDuration() {
		return duration;
	}
	
	public void setDuration(Short duration) {
		this.duration = duration;
	}
	
}
