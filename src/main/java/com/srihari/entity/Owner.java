package com.srihari.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String  ownername;
	
	private String password;

	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Owner(Integer id, String ownername, String password) {
		super();
		this.id = id;
		this.ownername = ownername;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getownername() {
		return ownername;
	}

	public void setownername(String adname) {
		this.ownername = adname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adname=" + ownername + ", password=" + password + "]";
	}
	
	
}
