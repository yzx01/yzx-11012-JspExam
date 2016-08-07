package com.web.fiter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	
	private String encoding = null;

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		
		if(encoding==null){
			System.out.println("没有指定字符编码集");
		}
		
	}
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		if(!encoding.equals(req.getCharacterEncoding())){
			req.setCharacterEncoding(encoding);
		}
		
		resp.setCharacterEncoding(encoding);
		chain.doFilter(req, resp);
	}
	
	public void destroy() {
		
		
	}

	
	

}
