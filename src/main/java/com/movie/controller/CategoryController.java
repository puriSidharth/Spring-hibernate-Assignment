package com.movie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.dto.ResponseEntityDto;
import com.movie.service.CategoryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	CategoryService service;

	@GetMapping
	@ApiOperation(value = "Get All Movie Categories")
	public ResponseEntityDto getMovieById() throws Exception {
		LOGGER.info(" *******  GET MOVIE RECORD  *******");
		return service.getAllCategories();
	}

}