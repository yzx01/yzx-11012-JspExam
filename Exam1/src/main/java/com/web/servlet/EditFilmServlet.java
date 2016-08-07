package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.bean.Film;
import com.web.dao.FilmDAO;
import com.web.dao.LanguageDAO;
import com.web.daoimpl.FilmDAOImpl;
import com.web.daoimpl.LanguageDAOImpl;
import com.web.util.ConnectionFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;



public class EditFilmServlet extends HttpServlet{
	FilmDAO filmdao = new FilmDAOImpl();
	LanguageDAO languagedao = new LanguageDAOImpl();
	private Configuration configuration = null;
	
	
	public void init() throws ServletException {
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String film_id = req.getParameter("film_id");
		ConnectionFactory factory = ConnectionFactory.getInstance();
		Connection conn = factory.makeConnection();
		Film film = filmdao.getAFilmMessage(conn, film_id);
		ArrayList languageList = languagedao.getAllLanguage(conn);
		Map dataMap = new HashMap();
		dataMap.put("film", film);
		dataMap.put("languageList",languageList);
		configuration.setServletContextForTemplateLoading(getServletContext(), "template");
		
		Template template = null;
		try {
			template = configuration.getTemplate("editfilm.ftl");
			template.setEncoding("UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		resp.setContentType("text/html; charset=" + template.getEncoding());
		PrintWriter out = resp.getWriter();

		try {
			template.process(dataMap, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
