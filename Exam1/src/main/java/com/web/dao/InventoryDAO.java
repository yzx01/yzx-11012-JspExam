package com.web.dao;

import java.sql.Connection;
import java.util.ArrayList;

public interface InventoryDAO {
	
	public Integer deleteInventory(Connection conn, String film_id);
	
	public ArrayList<Integer> getInventoryId(Connection conn,String film_id);

}
