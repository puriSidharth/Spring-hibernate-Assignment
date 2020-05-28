package com.movie;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.movie.dto.MovieDto;
import com.movie.dto.ResponseEntityDto;
import com.movie.service.CategoryService;
import com.movie.service.MovieService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieRatingsApplicationTests {

	public MovieRatingsApplicationTests() {
	}

	@Autowired
	MovieService movieService;

	@Autowired
	CategoryService categoryService;

	@Test
	public void addMovie() throws Exception {
		MovieDto movie = new MovieDto("CatchMovie", 1L, "4.5");
		ResponseEntityDto dto = movieService.addNewMovie(movie);
		Assert.assertEquals(dto.getCode(), HttpStatus.OK.value());
	}

	@Test
	public void addMovieWithoutCategory() throws Exception {
		MovieDto movie = new MovieDto("CatchMovie", null, "4.5");
		ResponseEntityDto dto = movieService.addNewMovie(movie);
		Assert.assertEquals(dto.getCode(), HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void addMovieWithWringRating() throws Exception {
		MovieDto movie = new MovieDto("CatchMovie", 1L, "9");
		ResponseEntityDto dto = movieService.addNewMovie(movie);
		Assert.assertEquals(dto.getCode(), HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void getMovie() throws Exception {
		ResponseEntityDto dto = movieService.getMovieById(1L);
		Assert.assertEquals(dto.getCode(), HttpStatus.OK.value());
	}
	
	@Test
	public void getMovieWithWrongId() throws Exception {
		ResponseEntityDto dto = movieService.getMovieById(300L);
		Assert.assertEquals(dto.getCode(), HttpStatus.OK.value());
	}

	@Test
	public void updateMovie() throws Exception {
		MovieDto movie = new MovieDto(1L, "Update Movie", 2L, "4.6");
		ResponseEntityDto dto = movieService.updateMovie(movie);
		Assert.assertEquals(dto.getCode(), HttpStatus.OK.value());
	}

	@Test
	public void updateMovieWithWringCategory() throws Exception {
		MovieDto movie = new MovieDto(1L, "Update Movie", null, "4.6");
		ResponseEntityDto dto = movieService.updateMovie(movie);
		Assert.assertEquals(dto.getCode(), HttpStatus.BAD_REQUEST.value());
	}

	@Test
	public void updateMovieWithWrongId() throws Exception {
		MovieDto movie = new MovieDto(300L, "Update Movie", 1L, "4.6");
		ResponseEntityDto dto = movieService.updateMovie(movie);
		Assert.assertEquals(dto.getCode(), HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void getAllMovies() throws Exception {
		ResponseEntityDto dto = movieService.getAllMovies();
		Assert.assertEquals(dto.getCode(), HttpStatus.OK.value());
	}

	@Test
	public void getAllCategories() throws Exception {
		ResponseEntityDto dto = categoryService.getAllCategories();
		Assert.assertEquals(dto.getCode(), HttpStatus.OK.value());
	}

}
