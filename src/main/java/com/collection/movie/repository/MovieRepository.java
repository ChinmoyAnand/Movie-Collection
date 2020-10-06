package com.collection.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collection.movie.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
