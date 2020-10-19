package Controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

  class Control_Rmi_Implement implements ControlRmi {
	Handle_API_ThoiTiet handle_APi_thoitiet = new Handle_Api_ThoiTiet_Implement();
	Get_Data_Gold getxauremote= new Get_Data_Gold_implements();
	Handle_API_Covid19 getdatacovid19= new Handle_API_Covid19_implement();
	Login_control login_check= new Login_control_implement();
	Regiser register= new Register_Implements();
	 Control_Rmi_Implement(){
		try {
			UnicastRemoteObject.exportObject(handle_APi_thoitiet);
			UnicastRemoteObject.exportObject(getxauremote);
			UnicastRemoteObject.exportObject(getdatacovid19);
			UnicastRemoteObject.exportObject(login_check);
			UnicastRemoteObject.exportObject(register);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Get_Data_Gold getRef_getxauRemote() throws RemoteException {
		// TODO Auto-generated method stub
		return getxauremote;
	}
	
	public Handle_API_Covid19 getRef_getdatacovdi19() throws RemoteException{
		return getdatacovid19;
	}
	@Override
	public Handle_API_ThoiTiet getRef_HandleAPI_ThoiTiet() throws RemoteException {
		// TODO Auto-generated method stub
		return handle_APi_thoitiet;
	}

	@Override
	public Login_control getRef_login_check() {
		// TODO Auto-generated method stub
		return login_check;
	}
	

	@Override
	public Regiser getRef_Register() throws RemoteException {
		// TODO Auto-generated method stub
		return register;
	}
}
