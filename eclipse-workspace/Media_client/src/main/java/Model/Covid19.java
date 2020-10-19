package Model;

import java.io.Serializable;

public class Covid19 implements Serializable{
 private String Mesage;
 private global Global;
 private countries[] Countries;
public String getMesage() {
	return Mesage;
}
public global getGlobal() {
	return Global;
}
public countries[] getCountries() {
	return Countries;
}
 
}
