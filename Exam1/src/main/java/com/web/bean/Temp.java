package com.web.bean;

public class Temp {
	
	private Film film;
	private Language language;
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public Temp(Film film, Language language) {
		this.film = film;
		this.language = language;
	}
	
	public Temp() {
		
	}
	
	

}
