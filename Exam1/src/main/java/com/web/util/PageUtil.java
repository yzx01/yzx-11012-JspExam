package com.web.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.bean.Film;
import com.web.bean.Language;
import com.web.bean.Temp;

public class PageUtil {
	
	public ArrayList getAllFilmByPage(Connection conn,int start,int count){
		ArrayList list = new ArrayList();
		String sql = "SELECT f.film_id,f.title,f.description,l.name FROM film f,language l WHERE f.language_id = l.language_id limit ?,?";
		PreparedStatement ps = null;
		ResultSet rs = null;
	     try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);
			rs = ps.executeQuery();
			while(rs.next()){
				Film f = new Film();
				f.setFilm_id(rs.getInt("film_id"));
				f.setTitle(rs.getString("title"));
				f.setDescription(rs.getString("description"));
				
				Language l = new Language();
				l.setName(rs.getString("name"));
				
				Temp t = new Temp(f,l);
				list.add(t);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!= null){
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
		return list;
		
	}
	
	public Integer getTotalPage(Connection conn){
		int totalcount = 0;
		int totalpage = 0;
		String sql = "SELECT COUNT(*) FROM film";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				totalcount = rs.getInt(1);
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
		totalpage = totalcount%8==0?totalcount/8:totalcount/8+1;
		return totalpage;
	}

}
