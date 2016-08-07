package com.web.dao;

import java.sql.Connection;
import java.util.ArrayList;

public interface PaymentDAO {
	
	public ArrayList<Integer> getPaymentById(Connection conn,ArrayList<Integer> list);
	
	public Integer deletePayment(Connection conn,ArrayList<Integer> list);

}
