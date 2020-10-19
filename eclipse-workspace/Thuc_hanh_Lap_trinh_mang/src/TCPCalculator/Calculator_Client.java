package TCPCalculator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Calculator_Client {
	public static void main(String [] args) throws UnknownHostException, IOException {
while(true) {
	Socket sk= new Socket("127.0.0.1",9981);
		Scanner in = new Scanner(System.in);
		System.out.println("A");
		int a= in.nextInt();
		System.out.println("B");
		int b= in.nextInt();
		System.out.println(" Phep Tinh: ");
		String pheptinh= in.next();
		sendata(a, b, pheptinh,sk);
		receiveData(sk);
		sk.close();
	}
	}
	public static void sendata(int a,int b, String pheptinh,Socket sk) throws UnknownHostException, IOException {
		PrintWriter print = new PrintWriter(sk.getOutputStream(),true);
		print.println(a);
		print.println(b);
		print.println(pheptinh);
		print.flush();
		
	}
	public static void receiveData(Socket sk) throws UnknownHostException, IOException {
		InputStreamReader read = new InputStreamReader(sk.getInputStream());
		BufferedReader reader= new BufferedReader(read);
		String resul =reader.readLine();
		System.out.println("Ket qua: "+resul);
		

	}

}
