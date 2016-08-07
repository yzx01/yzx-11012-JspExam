package com.web.dao;

import java.sql.Connection;

public interface FilmActorDAO {
	
	public Integer deleteFilmActor(Connection conn,String film_id);

}
