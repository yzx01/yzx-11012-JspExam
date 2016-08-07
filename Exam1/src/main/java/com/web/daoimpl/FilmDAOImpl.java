package com.web.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.bean.Film;
import com.web.bean.Language;
import com.web.bean.Temp;
import com.web.dao.FilmActorDAO;
import com.web.dao.FilmCategoryDAO;
import com.web.dao.FilmDAO;
import com.web.dao.InventoryDAO;
import com.web.dao.PaymentDAO;
import com.web.dao.RentalDAO;

public class FilmDAOImpl implements FilmDAO{
	FilmActorDAO filmactordao = new FilmActorDAOImpl();
	FilmCategoryDAO filmactegorydao = new FilmCategoryDAOImpl();
	InventoryDAO inventorydao = new InventoryDAOImpl();
	RentalDAO rentaldao = new RentalDAOImpl();
	PaymentDAO paymentdao = new PaymentDAOImpl();
	
	
	public Integer addFilm(Connection conn,String title,String description,String language_id) {
		PreparedStatement ps = null;
		int count =0;
		try {
			ps = conn.prepareStatement("INSERT INTO film(title,description,language_id) VALUES(?,?,?)");
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setInt(3, Integer.parseInt(language_id));
			count = ps.executeUpdate();
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
		
	}
	
	public Integer deleteFilm(Connection conn, String film_id) {
		int count = 0;
		PreparedStatement ps = null;
		filmactordao.deleteFilmActor(conn, film_id);
		filmactegorydao.deleteFilmCategory(conn, film_id);
		ArrayList<Integer> invenList = inventorydao.getInventoryId(conn, film_id);
		ArrayList<Integer> rentalList = rentaldao.getRentalId(conn, invenList);
		ArrayList<Integer> paymentList = paymentdao.getPaymentById(conn, rentalList);
		paymentdao.deletePayment(conn, paymentList);
		rentaldao.deleteRental(conn, rentalList);
		inventorydao.deleteInventory(conn, film_id);
		try {
			ps = conn.prepareStatement("DELETE FROM film WHERE film_id = ?");
			ps.setInt(1, Integer.parseInt(film_id));
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return count;
	}
	
	public Film getAFilmMessage(Connection conn, String film_id) {
		Film film = new Film();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("SELECT * FROM film  WHERE  film_id = ?");
			ps.setInt(1, Integer.parseInt(film_id));
			rs = ps.executeQuery();
			if(rs.next()){
				film.setFilm_id(rs.getInt("film_id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setLanguage_id(rs.getInt("language_id"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return film;
		
	}
	
	public Integer modifyFilm(Connection conn, String film_id, String title, String description, String language_id) {
		 PreparedStatement ps = null;
		 int count = 0;
		 try {
			ps = conn.prepareStatement("UPDATE film SET title=?,description=?,language_id=? WHERE film_id=?");
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setInt(3, Integer.parseInt(language_id));
			ps.setInt(4, Integer.parseInt(film_id));
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		 
		return count;
	}

}
