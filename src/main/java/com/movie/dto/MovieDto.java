package com.movie.dto;

public class MovieDto {

	private Long id;
	private String title;
	private String rating;
	private Long categoryId;
	
	public MovieDto() {
		
	}

	/**
	 * @param string
	 * @param l
	 * @param string2
	 */
	public MovieDto(String title, Long category, String rating) {
		this.title = title;
		this.categoryId = category;
		this.rating = rating;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param l
	 * @param string
	 * @param m
	 * @param string2
	 */
	public MovieDto(long id, String title, Long category, String rating) {
		this.id = id;
		this.title = title;
		this.categoryId = category;
		this.rating = rating;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
