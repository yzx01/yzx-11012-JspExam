package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.FilmDAO;
import com.web.daoimpl.FilmDAOImpl;
import com.web.util.ConnectionFactory;

public class AddFilmServlet extends HttpServlet{
	
	FilmDAO filmdao = new FilmDAOImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String language_id = req.getParameter("language_id");
		System.out.println(title+"  "+description+"    "+language_id);
		ConnectionFactory factory = ConnectionFactory.getInstance();
		Connection conn = factory.makeConnection();
		int count = filmdao.addFilm(conn, title, description, language_id);
		if(count==1){
			PrintWriter out = resp.getWriter();
			out.println("<script>"
					+ "alter('success')"
					+ "</script>");
			RequestDispatcher rd = req.getRequestDispatcher("allfilm.jsp");
			rd.forward(req, resp);
			
		}
		
	}
	

}
