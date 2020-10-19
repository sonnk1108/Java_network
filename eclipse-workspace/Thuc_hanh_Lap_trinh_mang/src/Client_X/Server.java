package Client_X;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.mysql.fabric.xmlrpc.base.Data;

public class Server {
	 public static void main(String[]args) {
		 try {
			ServerSocket socket=new ServerSocket(9000);
			Socket sk=socket.accept();
			System.out.println("server running....");
			DataOutputStream out = new DataOutputStream(sk.getOutputStream());
			DataInputStream in = new DataInputStream(sk.getInputStream());
			String name = in.readUTF();
			out.writeInt(5);
			out.writeInt(8);
			int tong=in.readInt();
			int tich=in.readInt();
			System.out.println("ten: \n"+name+"\ntong: "+tong+"tich \n"+tich);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
