package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_Studetn {
	static Socket sk= null;
	public static void main(String[]args) throws ClassNotFoundException {
		try {
			sk= new Socket("192.168.0.102",11001);
			ObjectOutputStream oos = new ObjectOutputStream(sk.getOutputStream());
			Student std= new Student("B17DCAT070","Nguyễn Minh Hiếu","192.168.0.021",1);
			oos.writeObject(std);
			System.out.println("Done");
			//ObjectInputStream iis = new ObjectInputStream(sk.getInputStream());
			//Answer asw = (Answer)iis.readObject();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
