

import java.io.Serializable;

public class Student implements Serializable {
	static final long serialVersionUID = 1L;
	public Student(String maSV, String hovaten, String iP, int group) {
		super();
		this.maSV = maSV;
		this.hovaten = hovaten;
		this.IP = iP;
		Group = group;
	}
	private String maSV;
	private String hovaten;
	private String IP;
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHovaten() {
		return hovaten;
	}
	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public int getGroup() {
		return Group;
	}
	public void setGroup(int group) {
		Group = group;
	}
	private int Group;

}
