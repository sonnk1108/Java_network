package Model;

import java.io.Serializable;

public class Gold implements Serializable{
	private String price;
	private String date;
	public Gold(String price, String date) {
		super();
		this.price = price;
		this.date = date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
