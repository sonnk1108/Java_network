package Model;

import java.io.Serializable;

public class User implements Serializable{
	private String name;
	private String pass;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(String text, String text2,String email) {
		// TODO Auto-generated constructor stub
		this.name=text;
		this.pass=text2;
		this.email=email;
	}
	public User(String text, String text2) {
		// TODO Auto-generated constructor stub
		this.name=text;
		this.pass=text2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
