package com.web.dao;

import java.sql.Connection;

public interface CustomerDAO {
	
	public boolean customerExits(Connection conn,String name);

}
