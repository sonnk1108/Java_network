package Danh_ba_dien_thoai;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_danhba {
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Client_danhba_view view = new Client_danhba_view();
		Client_Danhba_control danhba= new Client_Danhba_control(view);
		while(true) {
		danhba.run();
		}
	}
	

}
