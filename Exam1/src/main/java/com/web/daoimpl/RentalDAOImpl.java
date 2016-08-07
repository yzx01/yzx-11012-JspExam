package com.web.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.dao.RentalDAO;

public class RentalDAOImpl implements RentalDAO {

	public ArrayList<Integer> getRentalId(Connection conn, ArrayList<Integer> list) {
		PreparedStatement ps_ren = null;
		ArrayList<Integer> rentalList = new ArrayList<Integer>(); 
		ResultSet rs = null;
		for(int i = 0 ; i < list.size() ; i ++){
			try {
				ps_ren = conn.prepareStatement("SELECT DISTINCT rental_id FROM rental where inventory_id=?");
				ps_ren.setInt(1, list.get(i));
				rs = ps_ren.executeQuery();
				while(rs.next()){
					rentalList.add(rs.getInt("rental_id"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rentalList;
	}

	public Integer deleteRental(Connection conn, ArrayList<Integer> list) {
		PreparedStatement ps_ren = null;
		int count = 0;
		for(int i = 0 ; i < list.size() ; i ++){
			try {
				ps_ren = conn.prepareStatement("DELETE FROM rental WHERE rental_id = ?");
				ps_ren.setInt(1, list.get(i));
				count+=ps_ren.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(ps_ren!=null){
					try {
						ps_ren.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		return count;
	}

}
