package com.web.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.web.dao.FilmCategoryDAO;

public class FilmCategoryDAOImpl implements FilmCategoryDAO {

	public Integer deleteFilmCategory(Connection conn, String film_id) {
		PreparedStatement ps_cate = null;
		int count = 0;
		try {
			ps_cate = conn.prepareStatement("DELETE FROM film_category WHERE film_id=?");
			ps_cate.setInt(1, Integer.parseInt(film_id));
			count = ps_cate.executeUpdate();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps_cate!= null){
				try {
					ps_cate.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}

}
