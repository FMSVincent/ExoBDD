package fr.fms.entities;

public class Users {
	
	private String login;
	private String password;
	
	public Users(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Users [login=" + login + ", password=" + password + "]";
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
