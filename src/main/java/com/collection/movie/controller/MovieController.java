package com.collection.movie.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.collection.movie.entity.Movie;
import com.collection.movie.repository.MovieRepository;
/**
 * Controller and View Resolver for handling the Thymeleaf requests
 */
@Controller
public class MovieController {
	
	
	MovieRepository movieRepository;
	
	@Autowired
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	/**
     * Request to get the Default Index Page
     *
     * @param Model      the binding model
     * @return HTML page as String
     * 
     */
	@RequestMapping(value = "/")
    public String getAllMovies(Model model) 
    {
        model.addAttribute("movies", movieRepository.findAll());
        return "index";
    }
	
	/**
     * Request to get the Form to Add New Movie
     *
     * @param Movie      the movie to be added
     * @return HTML page as String
     * 
     */
	@GetMapping("/addup")
    public String showSignUpForm(Movie movie) {
        return "add-movie";
    }
    
    @PostMapping("/addmovie")
    public String addMovie(@Valid Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-movie";
        }
        
        movieRepository.save(movie);
        model.addAttribute("movies", movieRepository.findAll());
        return "redirect:/";
    }
    
    /**
     * Request to get the Form to Edit Movie
     *
     * @param Long      ID of the movie to be edited
     * @return HTML page as String
     * 
     */
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Movie movie = movieRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));
        
        model.addAttribute("movie", movie);
        return "update-movie";
    }
    
    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable("id") long id, @Valid Movie movie, 
      BindingResult result, Model model) {
        if (result.hasErrors()) {
        	movie.setId(id);
            return "update-movie";
        }
            
        movieRepository.save(movie);
        model.addAttribute("movies", movieRepository.findAll());
        return "redirect:/";
    }
        
    /**
     * Request to Delete a Movie based on ID.
     *
     * @param Long      ID of the movie to be deletedß
     * @return HTML page as String
     * 
     */
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") long id, Model model) {
        Movie movie = movieRepository.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));
        movieRepository.delete(movie);
        model.addAttribute("movies", movieRepository.findAll());
        return "redirect:/";
    }

}
