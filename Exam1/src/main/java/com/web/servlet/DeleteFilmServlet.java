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

public class DeleteFilmServlet extends HttpServlet{
	
	FilmDAO filmdao = new FilmDAOImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String film_id = req.getParameter("film_id");
		ConnectionFactory factory = ConnectionFactory.getInstance();
		Connection conn = factory.makeConnection();
		filmdao.deleteFilm(conn, film_id);
		RequestDispatcher rd = req.getRequestDispatcher("allfilm.jsp");
		rd.forward(req, resp);
	}

}
