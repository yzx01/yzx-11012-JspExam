package com.web.dao;

import java.sql.Connection;
import java.util.ArrayList;

public interface RentalDAO {
	
	public ArrayList<Integer> getRentalId(Connection conn,ArrayList<Integer> list);
	
	public Integer deleteRental(Connection conn,ArrayList<Integer> list);

}
