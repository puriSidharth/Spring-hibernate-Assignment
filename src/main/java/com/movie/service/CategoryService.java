package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.movie.dto.ResponseEntityDto;
import com.movie.model.Category;
import com.movie.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;

	public ResponseEntityDto getAllCategories() {
		List<Category> categoryList = categoryRepo.findAll();
		if (categoryList.size() > 0) {
			return new ResponseEntityDto(HttpStatus.OK.value(), HttpStatus.OK.name(), "Movie Deleted Successfully",
					categoryList);
		} else {
			return new ResponseEntityDto(HttpStatus.OK.value(), HttpStatus.OK.name(), "No category available",
					categoryList);
		}
	}

}