package com.web.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Language implements Serializable{
	
	private Integer language_id;
	private String name;
	private Timestamp last_update;
	public Integer getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(Integer language_id) {
		this.language_id = language_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	public Language() {
		
	}
	public Language(Integer language_id, String name, Timestamp last_update) {
		this.language_id = language_id;
		this.name = name;
		this.last_update = last_update;
	}
	public Language(String name) {
		this.name = name;
	}
	public Language(Integer language_id, String name) {
		this.language_id = language_id;
		this.name = name;
	}
	
	

}
