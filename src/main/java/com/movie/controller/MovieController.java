package com.movie.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.dto.MovieDto;
import com.movie.dto.ResponseEntityDto;
import com.movie.service.MovieService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	MovieService service;

	@GetMapping
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Movies Reterieved Successfully") })
	public ResponseEntityDto getAllMovies() throws Exception {
		LOGGER.info(" *******  GET ALL MOVIE RECORD - controller *******");
		return service.getAllMovies();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Get a single movie by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Movie Reterieved Successfully") })
	public ResponseEntityDto getMovieById(@PathVariable("id") Long id) throws Exception {
		LOGGER.info(" *******  GET MOVIE RECORD BY ID  - controller*******");
		return service.getMovieById(id);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a movie record by Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Movie Deleted Successfully") })
	public ResponseEntityDto deleteMovieById(@PathVariable("id") Long id) throws Exception {
		LOGGER.info(" *******  DELETE MOVIE RECORD - controller *******");
		return service.deleteMovieById(id);
	}

	@PostMapping("/addMovie")
	@ApiOperation(value = "Add a New Movie")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Movie Saved Successfully"),
			@ApiResponse(code = 400, message = "Movie must have a title."),
			@ApiResponse(code = 400, message = "Category is must"),
			@ApiResponse(code = 400, message = "Invalid Category") })
	public ResponseEntityDto addMovie(@RequestBody MovieDto dto, HttpServletRequest request) throws Exception {
		LOGGER.info(" *******  ADD NEW MOVIE RECORD - controller *******");
		return service.addNewMovie(dto);
	}

	@PutMapping("/updateMovie")
	@ApiOperation(value = "Update a movie")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Movie Updated Successfully"),
			@ApiResponse(code = 400, message = "Movie must have a title."),
			@ApiResponse(code = 400, message = "Category is must"),
			@ApiResponse(code = 400, message = "Invalid Category") })
	public ResponseEntityDto updateMovie(@RequestBody MovieDto dto, HttpServletRequest request) throws Exception {
		LOGGER.info(" *******  UPDATE MOVIE RECORD  - controller*******");
		return service.updateMovie(dto);
	}

}