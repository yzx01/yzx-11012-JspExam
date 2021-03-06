package com.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.bean.Pager;
import com.web.util.ConnectionFactory;
import com.web.util.PageUtil;

public class FilmServlet extends HttpServlet{
	PageUtil pageutil = new PageUtil();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		if(page==null){
			page="1";
		}
		System.out.println("===");
		int count = 8;
		int start = (Integer.parseInt(page)-1)*10;
		ConnectionFactory factory = ConnectionFactory.getInstance();
		Connection conn = factory.makeConnection();
		ArrayList list = pageutil.getAllFilmByPage(conn, start, count);
		int totalpage = pageutil.getTotalPage(conn);
		Pager pager = new Pager();
		pager.setList(list);
		pager.setPage(page);
		pager.setTotalPage(totalpage);
		req.setAttribute("pager", pager);
		RequestDispatcher rd = req.getRequestDispatcher("allfilm.jsp");
		rd.forward(req, resp);
	}

}
