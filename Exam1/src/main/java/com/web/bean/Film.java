package com.web.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Film implements Serializable{
	private Integer film_id;
	private String title;
	private String description;
	private Date release_year;
	private Integer language_id;
	private Integer original_language_id;
	private Integer rental_duration;
	private BigDecimal rental_rate;
    private Integer length;
	public Integer getFilm_id() {
		return film_id;
	}
	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getRelease_year() {
		return release_year;
	}
	public void setRelease_year(Date release_year) {
		this.release_year = release_year;
	}
	public Integer getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(Integer language_id) {
		this.language_id = language_id;
	}
	public Integer getOriginal_language_id() {
		return original_language_id;
	}
	public void setOriginal_language_id(Integer original_language_id) {
		this.original_language_id = original_language_id;
	}
	public Integer getRental_duration() {
		return rental_duration;
	}
	public void setRental_duration(Integer rental_duration) {
		this.rental_duration = rental_duration;
	}
	public BigDecimal getRental_rate() {
		return rental_rate;
	}
	public void setRental_rate(BigDecimal rental_rate) {
		this.rental_rate = rental_rate;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Film() {
		
	}
	public Film(Integer film_id, String title, String description, Date release_year, Integer language_id,
			Integer original_language_id, Integer rental_duration, BigDecimal rental_rate, Integer length) {
		this.film_id = film_id;
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.language_id = language_id;
		this.original_language_id = original_language_id;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.length = length;
	}
	public Film(Integer film_id, String title, String description) {
		this.film_id = film_id;
		this.title = title;
		this.description = description;
	}
	public Film(Integer film_id, String title, String description, Integer language_id) {
		this.film_id = film_id;
		this.title = title;
		this.description = description;
		this.language_id = language_id;
	}
	
	
    
}
