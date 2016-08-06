package com.web.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.CustomerDAO;
import com.web.daoimpl.CustomerDAOImpl;
import com.web.util.ConnectionFactory;



public class LoginServlet extends HttpServlet{
	CustomerDAO customerdao = new CustomerDAOImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("user_name");
		ConnectionFactory factory = ConnectionFactory.getInstance();
		Connection conn = factory.makeConnection();
		boolean flag = customerdao.customerExits(conn, name);
		if(flag){
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}else{
			resp.sendRedirect("login.jsp");
		}
		
	}

}
