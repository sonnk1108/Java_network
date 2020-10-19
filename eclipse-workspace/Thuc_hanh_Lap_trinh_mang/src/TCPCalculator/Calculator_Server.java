package TCPCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Calculator_Server {
	public static void main(String []args) {
		try {
			ServerSocket skv= new ServerSocket(9981);
			System.out.println("Server Running......");
			while(true) {
				Socket sk =skv.accept();
				new Thread(new Calculator(sk));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
class Calculator extends Thread {
	Socket client =null;
	BufferedReader read=null;
	PrintWriter print=null;
	Calculator(Socket client){
		this.client=client;
		start();
	}
	public void run() {
		 try {
			read= new BufferedReader(new InputStreamReader(client.getInputStream()));
			String a=read.readLine();
			String b=read.readLine();
			String c=read.readLine();
			print= new PrintWriter(client.getOutputStream());
			switch(c) {
			case "+": 
				int result=Integer.parseInt(a)+Integer.parseInt(b);
				print.println(result);
				print.flush();
			case "-": 
				int result2=Integer.parseInt(a)-Integer.parseInt(b);
				print.println(result2);
				print.flush();
				
			
		 case "*": 
				int result3=Integer.parseInt(a)*Integer.parseInt(b);
				print.println(result3);
				print.flush();
		 case "/": 
				int result4=Integer.parseInt(a)/Integer.parseInt(b);
				print.println(result4);
				print.flush();
				
			}
			
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
}
