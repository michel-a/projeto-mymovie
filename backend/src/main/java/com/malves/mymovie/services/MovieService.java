package com.malves.mymovie.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malves.mymovie.entities.Movie;
import com.malves.mymovie.entities.dtos.MovieDto;
import com.malves.mymovie.repositories.MovieRepository;

@Service
public class MovieService {

	private final MovieRepository repository;
	
	public MovieService(MovieRepository repository) {
		this.repository = repository;
	}
	
	@Transactional(readOnly = true)
	public ResponseEntity<Page<MovieDto>> findAll(Pageable pageable) {
		Page<Movie> result = repository.findAll(pageable);
		Page<MovieDto> page = result.map(x -> new MovieDto(x));
		return ResponseEntity.ok(page);
	}
	
	@Transactional(readOnly = true)
	public ResponseEntity<MovieDto> findById(Integer id) {
		Optional<Movie> movieOptional = repository.findById(id);
		if(movieOptional.isPresent()) {
			MovieDto dto = new MovieDto(movieOptional.get());
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Transactional
	public ResponseEntity<MovieDto> save(MovieDto dto) {
		var movie = new Movie();
		BeanUtils.copyProperties(dto, movie);
		MovieDto movieDto = new MovieDto(repository.save(movie));
		return ResponseEntity.ok(movieDto);
	}
	
	@Transactional
	public ResponseEntity<MovieDto> update(MovieDto dto) {
		var movie = new Movie();
		BeanUtils.copyProperties(dto, movie);
		Optional<Movie> movieOptional = repository.findById(movie.getId());
		if(movieOptional.isPresent()) {
			MovieDto movieDto = new MovieDto(repository.save(movie));
			return ResponseEntity.ok( movieDto );
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Transactional
	public ResponseEntity<?> delete(Integer id) {
		Optional<Movie> result= repository.findById(id);
		if(result.isPresent()) {
			repository.delete(result.get());
			return ResponseEntity.ok().body("Filme removido com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
