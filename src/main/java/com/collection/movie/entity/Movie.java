package com.collection.movie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank(message = "Movie Title is mandatory")
    private String title;
    
    @NotBlank(message = "Genre is mandatory")
    private String genre;
    
    @Max(value = 2020)
    @Min(value = 1800)
    private int year;
    
    @Max(value = 5)
    private int rating;

	public Movie(@NotBlank(message = "Movie Title is mandatory") String title,
			@NotBlank(message = "Genre is mandatory") String genre, @Max(2020) @Min(1800) int year,
			@Max(5) int rating) {
		super();
		this.title = title;
		this.genre = genre;
		this.year = year;
		this.rating = rating;
	}
    
}