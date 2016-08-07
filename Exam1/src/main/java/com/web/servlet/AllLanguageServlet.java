package com.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.LanguageDAO;
import com.web.daoimpl.LanguageDAOImpl;
import com.web.util.ConnectionFactory;

public class AllLanguageServlet extends HttpServlet{
	
	LanguageDAO languagedao = new LanguageDAOImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ConnectionFactory factory = ConnectionFactory.getInstance();
		Connection conn = factory.makeConnection();
		ArrayList language = languagedao.getAllLanguage(conn);
		req.setAttribute("language", language);
		RequestDispatcher rd = req.getRequestDispatcher("addfilm.jsp");
		rd.forward(req, resp);
		
	}
	

}
