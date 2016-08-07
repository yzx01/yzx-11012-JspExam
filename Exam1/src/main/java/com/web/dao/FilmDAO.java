package com.web.dao;

import java.sql.Connection;

import com.web.bean.Film;
import com.web.bean.Temp;

public interface FilmDAO {
	
	public Integer addFilm(Connection conn,String title,String description,String language_id);
	
	public Integer deleteFilm(Connection conn,String film_id);
	
	public Film getAFilmMessage(Connection conn,String film_id);
	
	public Integer modifyFilm(Connection conn,String film_id,String title,String description,String language_id);

}
