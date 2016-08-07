package com.web.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.web.dao.FilmActorDAO;

public class FilmActorDAOImpl implements FilmActorDAO {

	public Integer deleteFilmActor(Connection conn, String film_id) {
		PreparedStatement ps_actor = null;
		int count = 0;
		try {
			ps_actor = conn.prepareStatement("DELETE FROM film_actor WHERE film_id=?");
			ps_actor.setInt(1, Integer.parseInt(film_id));
			count=ps_actor.executeUpdate();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps_actor!=null){
				try {
					ps_actor.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}

}
