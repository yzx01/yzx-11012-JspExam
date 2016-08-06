package com.web.bean;

import java.util.ArrayList;

public class Pager {

	private ArrayList list = new ArrayList();
	private Integer totalPage;
	private String page;

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Pager(ArrayList list, Integer totalPage, String page) {
		this.list = list;
		this.totalPage = totalPage;
		this.page = page;
	}

	public Pager() {

	}

}
