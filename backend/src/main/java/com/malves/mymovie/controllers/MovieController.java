package com.malves.mymovie.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malves.mymovie.entities.dtos.MovieDto;
import com.malves.mymovie.services.MovieService;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin("*")
public class MovieController {
	
	@Autowired
	private MovieService service;

	@GetMapping
	public ResponseEntity<Page<MovieDto>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
		return service.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieDto> findById(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<MovieDto> save(@RequestBody @Valid MovieDto dto) {
		return service.save(dto);
	}
	
	@PutMapping
	public ResponseEntity<MovieDto> update(@RequestBody @Valid MovieDto dto) {
		return service.update(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return service.delete(id);
	}
}
