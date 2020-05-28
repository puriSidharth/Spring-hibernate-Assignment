package com.movie.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.movie.dto.MovieDto;
import com.movie.dto.ResponseEntityDto;
import com.movie.model.Category;
import com.movie.model.Movie;
import com.movie.repository.CategoryRepository;
import com.movie.repository.MovieRepository;

@Service
public class MovieService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

	@Autowired
	MovieRepository repository;

	@Autowired
	CategoryRepository categoryRepo;

	/**
	 * @createdBy puriSidharth
	 * @createdOn May 26, 2020
	 * @param dto
	 * @return List<Movie>
	 */
	public ResponseEntityDto getAllMovies() {
		LOGGER.info(" *******  GET ALL MOVIE RECORD - service *******");
		List<Movie> movieList = repository.findAll();
		if (movieList.size() > 0) {
			return new ResponseEntityDto(HttpStatus.OK.value(), HttpStatus.OK.name(), "Movie Reterieved Successfull.y",
					movieList);
		} else {
			return new ResponseEntityDto(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), "No movie found.");
		}
	}

	/**
	 * @createdBy puriSidharth
	 * @createdOn May 26, 2020
	 * @param dto
	 * @return Movie
	 */
	public ResponseEntityDto getMovieById(Long id) throws Exception {
		LOGGER.info(" *******  GET MOVIE RECORD BY ID  - service*******");
		Optional<Movie> movie = repository.findById(id);
		if (movie.isPresent()) {
			return new ResponseEntityDto(HttpStatus.OK.value(), HttpStatus.OK.name(), "Movie Reterieved Successfully",
					movie.get());
		} else {
			return new ResponseEntityDto(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),
					"No movie record exist for given id");
		}
	}

	/**
	 * @createdBy puriSidharth
	 * @createdOn May 26, 2020
	 * @param dto
	 * @return Movie
	 */
	public ResponseEntityDto deleteMovieById(Long id) throws Exception {
		LOGGER.info(" *******  DELETE MOVIE RECORD - controller *******");
		Optional<Movie> movie = repository.findById(id);
		if (movie.isPresent()) {
			repository.deleteById(id);
			return new ResponseEntityDto(HttpStatus.OK.value(), HttpStatus.OK.name(), "Movie Deleted Successfully");
		} else {
			return new ResponseEntityDto(HttpStatus.OK.value(), HttpStatus.OK.name(),
					"No movie record exist for given id");
		}
	}

	/**
	 * @createdBy puriSidharth
	 * @createdOn May 26, 2020
	 * @param dto
	 * @return Movie
	 * @throws Exception
	 */

	public ResponseEntityDto addNewMovie(MovieDto dto) throws Exception {
		LOGGER.info(" *******  ADD NEW MOVIE RECORD - service *******");
		if (dto.getRating() != null) {
			if (Double.valueOf(dto.getRating()) < 0.5 || Double.valueOf(dto.getRating()) > 5) {
				return new ResponseEntityDto(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
						"Rating must be between 0.5 and 5.");
			}
		}

		if (dto.getTitle() == null || dto.getTitle() == "") {
			return new ResponseEntityDto(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
					"Movie must have a title.");
		}
		Optional<Category> cat = null;
		if (dto.getCategoryId() == null) {
			return new ResponseEntityDto(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
					"Category is must");
		} else {
			cat = categoryRepo.findById(dto.getCategoryId());
			if (!cat.isPresent()) {
				return new ResponseEntityDto(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
						"Invalid Category");
			}
		}

		Movie movie = new Movie();
		movie.setTitle(dto.getTitle());
		movie.setCategory(cat.get());
		movie.setRating(dto.getRating() != null ? Double.valueOf(dto.getRating()) : null);
		movie = repository.saveAndFlush(movie);
		return new ResponseEntityDto(HttpStatus.OK.value(), HttpStatus.OK.name(), "Movie Saved Successfully", movie);
	}

	/**
	 * @createdBy puriSidharth
	 * @createdOn May 26, 2020
	 * @param dto
	 * @return Movie
	 * @throws Exception
	 */

	public ResponseEntityDto updateMovie(MovieDto dto) throws Exception {
		LOGGER.info(" *******  UPDATE MOVIE RECORD - service *******");
		Optional<Movie> movie = repository.findById(dto.getId());

		if (movie.isPresent()) {
			if (dto.getRating() != null) {
				if (Double.valueOf(dto.getRating()) < 0.5 || Double.valueOf(dto.getRating()) > 5) {
					return new ResponseEntityDto(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
							"Rating must be between 0.5 and 5.");
				}
			}

			if (dto.getTitle() == null || dto.getTitle() == "") {
				return new ResponseEntityDto(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
						"Movie must have a title.");
			}
			Optional<Category> cat = null;
			if (dto.getCategoryId() == null) {
				return new ResponseEntityDto(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
						"Category is must");
			} else {
				cat = categoryRepo.findById(dto.getCategoryId());
				if (!cat.isPresent()) {
					return new ResponseEntityDto(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(),
							"Invalid Category");
				}
			}
			Movie updatemovie = movie.get();
			updatemovie.setTitle(dto.getTitle());
			updatemovie.setCategory(cat.get());
			updatemovie.setRating(dto.getRating() != null ? Double.valueOf(dto.getRating()) : null);
			updatemovie = repository.saveAndFlush(updatemovie);
			return new ResponseEntityDto(HttpStatus.OK.value(), HttpStatus.OK.name(), "Movie Updated Successfully",
					updatemovie);
		} else {
			return new ResponseEntityDto(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),
					"No movie record exist for given id");
		}
	}
}