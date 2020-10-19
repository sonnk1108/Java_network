package Danh_ba_dien_thoai;

import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private String located;
	private String phonenumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person(String name,  String phonenumber,String located) {
		super();
		this.name = name;
		this.located = located;
		this.phonenumber = phonenumber;
	}
	public String getLocated() {
		return located;
	}
	public void setLocated(String located) {
		this.located = located;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}
