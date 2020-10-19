package Controller;

import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

public class MediaServer {
	public void run() {
		try {
			//khoi tao doi tuong c
			ControlRmi f= new Control_Rmi_Implement();
			//dang ki voi may ao java
			UnicastRemoteObject.exportObject(f);
			String url="rmi://localhost:9981/fxObj";
			Naming.bind(url,f);
			System.out.println("server RMI ready....");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
