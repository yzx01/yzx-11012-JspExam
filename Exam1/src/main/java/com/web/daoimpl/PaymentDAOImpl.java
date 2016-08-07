package com.web.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.dao.PaymentDAO;

public class PaymentDAOImpl implements PaymentDAO {

	public ArrayList<Integer> getPaymentById(Connection conn, ArrayList<Integer> list) {
		PreparedStatement ps_pay = null;
		ResultSet rs = null;
		ArrayList<Integer> payList = new ArrayList<Integer>();
		for(int i = 0 ; i < list.size() ; i ++){
			try {
				ps_pay = conn.prepareStatement("SELECT DISTINCT payment_id FROM payment WHERE rental_id = ?");
				ps_pay.setInt(1, list.get(i));
				rs = ps_pay.executeQuery();
				while(rs.next()){
					payList.add(rs.getInt("payment_id"));
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
				if(ps_pay!=null){
					try {
						ps_pay.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		return payList;
	}
	
	public Integer deletePayment(Connection conn,ArrayList<Integer> list){
		int count = 0;
		PreparedStatement ps_pay = null;
		for(int i = 0 ; i < list.size() ; i ++){
			try {
				ps_pay = conn.prepareStatement("DELETE FROM payment WHERE payment_id = ?");
				ps_pay.setInt(1, list.get(i));
				count+=ps_pay.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(ps_pay!=null){
					try {
						ps_pay.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		return count ;
	}

}
