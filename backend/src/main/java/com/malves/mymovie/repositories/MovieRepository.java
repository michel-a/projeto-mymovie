package com.malves.mymovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malves.mymovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
