	package Server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import LoginClient.User;
public class ServerControl {
	private Connection con;
	private ServerSocket myServer;
	private Socket clientSocket;
	private int serverPort=8888;
	private serverview view;
	public ServerControl(serverview view) {
		this.view=view;
		getDBConnection("user", "root","Admin");
		openServer(serverPort);
		view.showMessage("TCP server is running");
		while(true) {
			listening();
		}
	}
	private void listening() {
		// Xy ly su kien lang nghe
		try { 
			//chap nhan ket noi
			clientSocket=myServer.accept();
			ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
			//nhan input la object user
			ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
			//truyen doi tuong o la doi tuong nhan duoc tu client
			Object o = ois.readObject();
			
			if( o instanceof User) {
				User user = (User)o;
				if(checkUser(user)) {
					System.out.println(checkUser(user));
					oos.writeObject("ok");
				} else oos.writeObject("false");
				System.out.println(checkUser(user));

			}
				} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private boolean checkUser(User user) {
		String query="Select *From `user` where username=? AND password =?";
		try {
			java.sql.PreparedStatement conn= con.prepareStatement(query);
			conn.setString(1,user.getUserName());
			conn.setString(2, user.getPassword());
			ResultSet rs =conn.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch(Exception ex) {
		}
		return false;
	}
	private void openServer(int serverPort2) {
		// mo coong 8888 de lang nghe client
	 try {
		myServer = new ServerSocket(serverPort2);
	} catch (IOException e) {
		view.showMessage(e.getStackTrace().toString());
	}
	}
	private void getDBConnection(String dbname, String usrname, String pwd) {
		// ket noi co so du lieu
		String dbUrl = "jdbc:mysql://localhost:3306/user";
		String dbClass="com.mysql.jdbc.Driver";
		try {
			Class.forName(dbClass);
			con=DriverManager.getConnection(dbUrl, usrname, pwd);
			
		}catch(Exception ex) {
			view.showMessage(ex.getStackTrace().toString());
		}	
	}

}
