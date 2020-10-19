package LoginClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientControl {
	private ClienView view;
	private String serverHost="localhost";
	private int serverePort =8888;
	public ClientControl(ClienView view) {
		this.view=view;
		this.view.addLoginListener(new LoginListener());
		
	}
	class LoginListener implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				User user= view.getUser();
				//Tạo đối tượng socket 
				Socket mySocket = new Socket(serverHost,serverePort);
				//Tạo luồng output để gửi đến server
				ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
				oos.writeObject(user);
				// Lắng nghe kết quả trả về
				ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
				Object o = ois.readObject();
				if(o instanceof String) {
					String result=(String)o;
					if(result.equals("ok")) {
						view.showMessage("Login succesfull");
					} else view.showMessage("Login failed");
				} mySocket.close();
				
			} catch (Exception ex) {
				ex.getMessage();
			}
			// TODO Auto-generated method stub
			
		}
		
	}

}
