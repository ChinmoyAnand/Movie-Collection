package com.collection.movie.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.collection.movie.entity.Movie;
import com.collection.movie.repository.MovieRepository;

@SpringBootTest
public class MovieControllerUnitTest {
	private static MovieController movieController;
    private static MovieRepository mockedMovieRepository;
    private static BindingResult mockedBindingResult;
    private static Model mockedModel;
    
    @BeforeAll
    public static void setUpmovieControllerInstance() {
    	mockedMovieRepository = mock(MovieRepository.class);
        mockedBindingResult = mock(BindingResult.class);
        mockedModel = mock(Model.class);
        movieController = new MovieController(mockedMovieRepository);
    }
    
    @Test
    public void whenCalledshowSignUpForm_thenCorrect() {
        Movie movie = new Movie("John", "Action",1986,4);

        assertThat(movieController.showSignUpForm(movie)).isEqualTo("add-movie");
    }
    
    @Test
    public void whenCalledaddMovieAndValidMovie_thenCorrect() {
    	Movie movie = new Movie("Johnyy", "Action",1986,4);

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(movieController.addMovie(movie, mockedBindingResult, mockedModel)).isEqualTo("redirect:/");
    }

    @Test
    public void whenCalledaddMovieAndInValidMovie_thenCorrect() {
    	Movie movie = new Movie("John", "Action",1986,4);

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(movieController.addMovie(movie, mockedBindingResult, mockedModel)).isEqualTo("add-movie");
    }

    @Test
    public void whenCalledshowUpdateForm_thenIllegalArgumentException() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		movieController.showUpdateForm(0, mockedModel);
    	  });
    }
    
    @Test
    public void whenCalledupdateMovieAndValidMovie_thenCorrect() {
    	Movie movie = new Movie("John", "Action",1986,4);

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(movieController.updateMovie(1l, movie, mockedBindingResult, mockedModel)).isEqualTo("redirect:/");
    }

    @Test
    public void whenCalledupdateMovieAndInValidMovie_thenCorrect() {
    	Movie movie = new Movie("John", "Action",1986,4);

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(movieController.updateMovie(1l, movie, mockedBindingResult, mockedModel)).isEqualTo("update-movie");
    }

}
