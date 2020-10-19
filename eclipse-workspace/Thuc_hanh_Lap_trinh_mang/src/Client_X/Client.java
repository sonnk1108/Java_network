package Client_X;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main (String [] args) {
		try {
			Socket sk= new Socket("Localhost",9000);
			DataOutputStream out = new DataOutputStream(sk.getOutputStream());
			out.writeUTF("B17DCAT157;800");
			DataInputStream in = new DataInputStream(sk.getInputStream());
			int a=in.readInt();
			int b=in.readInt();
			out.writeInt(a+b);
			out.writeInt(a*b);
			in.close();
			out.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
