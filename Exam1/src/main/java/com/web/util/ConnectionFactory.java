package com.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *数据库静态工厂类 
 * 
 */

public class ConnectionFactory {

	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;

	private static final ConnectionFactory factory = new ConnectionFactory();

	private Connection conn = null;

	static {
		Properties prop = new Properties();
		try {
			InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}

	private ConnectionFactory() {

	}

	public static ConnectionFactory getInstance() {
		return factory;
	}

	public Connection makeConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

}
