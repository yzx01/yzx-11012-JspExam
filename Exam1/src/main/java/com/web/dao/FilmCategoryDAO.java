package com.web.dao;

import java.sql.Connection;

public interface FilmCategoryDAO {
	
	public Integer deleteFilmCategory(Connection conn,String film_id);

}
