package Danh_ba_dien_thoai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Client_Danhba_control {
	Client_danhba_view view;
	ObjectOutputStream oos =null;
	ObjectInputStream ois =null;
	Socket sk=null;
	
	public Client_Danhba_control(Client_danhba_view view) {
		this.view=view;
	}
	public void run() throws IOException, ClassNotFoundException {
		Socket sk= new Socket("127.0.0.1",9981);
			oos = new ObjectOutputStream(sk.getOutputStream());
			int choice =this.view.menu();
			switch(choice) {
			case 1 : 
				
				oos.writeObject(choice);
				oos.flush();
				Person p = this.view.person();
				oos.writeObject(p);
				oos.flush();
				//Person p =this.view.person();
				//Outobj.writeObject(p);
				//Outobj.flush();
				ois= new ObjectInputStream(sk.getInputStream());
				String in=(String)ois.readObject();
				this.view.Messageg(in);
				break;
			case 2:
				oos.writeObject(choice);
				String name = this.view.getName();
				oos.writeObject(name);
				oos.flush();
				String getphone=(String)ois.readObject();
				this.view.Messageg(getphone);
				break;
				
			case 3 : 
				oos.writeObject(choice);
				oos.flush();
				ArrayList<Person> per = (ArrayList<Person>)ois.readObject();
				for( Person s : per) {
					System.out.println("NAME :"+s.getName()+"\n Phone: "+s.getPhonenumber()+"\n Locate: "+s.getLocated());
				}
				
				break;
			case 4: 
				oos.writeObject(choice);
				oos.flush();
				String person = this.view.getName();
				oos.writeObject(person);
				oos.flush();
				Person getPerson=(Person)ois.readObject();
				System.out.println("Name: "+getPerson.getName()+"\nPhone Number: "+getPerson.getPhonenumber()+"\n Location: "+getPerson.getLocated());;
				break;
				
			}

	}

}
