package com.srihari.dto;

public class LoginRequest {

      private Integer id;
	
	private String password;

	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginRequest(Integer id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest [id=" + id + ", password=" + password + "]";
	}

	
}
