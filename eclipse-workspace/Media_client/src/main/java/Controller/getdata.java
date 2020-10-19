package Controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Model.Covid19;
import Model.Gold;
import Model.JsonResult;
import Model.User;

public class getdata {
	private	ControlRmi x=null ;
	public getdata(){
		connect();
	}
	public JsonResult getData() throws RemoteException {
		Handle_API_ThoiTiet	test = x.getRef_HandleAPI_ThoiTiet();
		JsonResult data=test.getJsonData("");
			return data;
		
	}
	public Covid19 getCovid19() throws RemoteException {
		Covid19 cv19= new Covid19();
		Handle_API_Covid19 get= x.getRef_getdatacovdi19();
		cv19 =get.getcoviddata();
		return cv19;
		
	}
	public ArrayList<Gold> getxau() throws RemoteException{
		ArrayList<Gold> data = new ArrayList<>();
		Get_Data_Gold get= null;
		try {
		get	= x.getRef_getxauRemote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data=get.getDB();
		return data;
		
	}
	public boolean Login_check(User us) throws RemoteException {
		Login_control login=x.getRef_login_check();
		if(login.check_login(us).equals("OK")) {
			return true;
		}
		return false;
	}
	public void Register(User us) throws RemoteException {
		Regiser rs=x.getRef_Register();
		rs.regiter_user(us);
		
	}
	public void connect() {
		String url="rmi://localhost:9981/fxObj";
		try {
			 x =(ControlRmi) Naming.lookup(url);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
