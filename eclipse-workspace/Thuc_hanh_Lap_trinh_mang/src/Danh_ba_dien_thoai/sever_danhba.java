package Danh_ba_dien_thoai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class sever_danhba implements Registry_itf{
	ArrayList<Person> person = new ArrayList<>();
	static ObjectOutputStream oos =null;
	static ObjectInputStream ois =null;
	static ServerSocket ske;
	public   void Listening () throws ClassNotFoundException {
		try {
			System.out.print("Server is running.....");
			ske = new ServerSocket(9981);
		    sever_danhba danhba= new sever_danhba();
		    while(true) {
			running();
		    
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	public   void running( ) throws ClassNotFoundException, IOException {
		Socket sk=ske.accept();
		ois= new ObjectInputStream(sk.getInputStream());
		// TODO Auto-generated method stub
		int choice= (int)(ois.readObject());
		switch(choice) {
		case 1:
			Person p =(Person) ois.readObject();
			oos = new ObjectOutputStream(sk.getOutputStream());
			oos.writeObject("OK "+p.getName());
			oos.flush();
			add(p);
			break;
		case 2 : 
			String name = (String)ois.readObject();
			String getphone=getPhone(name);
			oos.writeObject(getphone);
			oos.flush();
			break;
		case 3: 
			oos.writeObject(person);
			oos.flush();
			break;
		case 4: 
			String name3 = (String)ois.readObject();
			Person person1=search(name3);
			oos.writeObject(person1);
			oos.flush();
			break;
			
		}
		
			
		
	}
	@Override
	public void add(Person p) {
		// TODO Auto-generated method stub
		person.add(p);
	}

	@Override
	public String getPhone(String name) {
		// TODO Auto-generated method stub
		String name2="Khong tim thay ket qua";
		for(Person p : person) {
			if(p.getName().equals(name)) {
				name2= p.getPhonenumber();
			}
		}
		
		
		return name2;
	}

	@Override
	public Iterable<Person> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person search(String name) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Person person1= new Person("","","");
		for(Person p : person) {
			if(p.getName().equals(name)) {
				person1=p;
			}
		}
		
		
		return person1;
	}

	

}
