package com.web.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.dao.InventoryDAO;

public class InventoryDAOImpl implements InventoryDAO {

	public Integer deleteInventory(Connection conn, String film_id) {
		PreparedStatement ps_inve = null;
		int count = 0 ;
		try {
			ps_inve = conn.prepareStatement("DELETE FROM inventory WHERE film_id=?");
			ps_inve.setInt(1, Integer.parseInt(film_id));
			count = ps_inve.executeUpdate();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps_inve!= null){
				try {
					ps_inve.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
	public ArrayList<Integer> getInventoryId(Connection conn, String film_id) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		PreparedStatement ps_inve = null;
		ResultSet rs = null;
		try {
			ps_inve = conn.prepareStatement("SELECT DISTINCT inventory_id FROM inventory WHERE film_id=?");
			ps_inve.setInt(1, Integer.parseInt(film_id));
			rs = ps_inve.executeQuery();
			while(rs.next()){
				list.add(rs.getInt("inventory_id"));
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
			if(ps_inve!=null){
				try {
					ps_inve.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}

	

}
