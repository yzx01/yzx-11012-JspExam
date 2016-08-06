package com.web.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Customer implements Serializable{
	
	private Integer customer_id;
	private Integer store_id;
	private String first_name;
	private String last_name;
	private String email;
	private Integer address_id;
	private Integer active;
	private Timestamp create_date;
	private Timestamp last_date;
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public Date getLast_date() {
		return last_date;
	}
	public void setLast_date(Timestamp last_date) {
		this.last_date = last_date;
	}
	public Customer() {
	
	}
	public Customer(Integer customer_id, Integer store_id, String first_name, String last_name, String email,
			Integer address_id, Integer active, Timestamp create_date, Timestamp last_date) {
		this.customer_id = customer_id;
		this.store_id = store_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.address_id = address_id;
		this.active = active;
		this.create_date = create_date;
		this.last_date = last_date;
	}
	

}
