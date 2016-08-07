package com.web.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.FilmDAO;
import com.web.daoimpl.FilmDAOImpl;
import com.web.util.ConnectionFactory;

public class ModifyServlet extends HttpServlet{
	
	FilmDAO filmdao = new FilmDAOImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String film_id = req.getParameter("film_id");
		System.out.println(film_id);
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String language_id = req.getParameter("language_id");
		ConnectionFactory factory = ConnectionFactory.getInstance();
		Connection conn = factory.makeConnection();
		int count = filmdao.modifyFilm(conn, film_id, title, description, language_id);
		RequestDispatcher rd = req.getRequestDispatcher("allfilm.jsp");
		rd.forward(req, resp);
		
	}

}
