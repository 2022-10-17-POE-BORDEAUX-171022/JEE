package com.jee.modele;

public class User {
	int id;
	String email;
	String login;
	String password;
	
	public User(int id, String email, String login, String password) {
		this.id = id;
		this.email = email;
		this.login = login;
		this.password = password;
	}
	
	public User(String email, String login, String password) {

		this.email = email;
		this.login = login;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
