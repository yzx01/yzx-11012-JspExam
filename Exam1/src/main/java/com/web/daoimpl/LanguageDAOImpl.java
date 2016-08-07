package com.web.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.bean.Language;
import com.web.dao.LanguageDAO;

public class LanguageDAOImpl implements LanguageDAO{

	public ArrayList getAllLanguage(Connection conn) {
		ArrayList list = new ArrayList();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("SELECT * FROM language");
			rs = ps.executeQuery();
			while(rs.next()){
			  Language language = new Language();
			  language.setLanguage_id(rs.getInt("language_id"));
			  language.setName(rs.getString("name"));
			  list.add(language);
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

}
