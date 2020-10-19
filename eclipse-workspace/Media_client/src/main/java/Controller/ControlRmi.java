package Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControlRmi extends Remote {
	public Handle_API_ThoiTiet getRef_HandleAPI_ThoiTiet() throws RemoteException;
	public Get_Data_Gold getRef_getxauRemote() throws RemoteException;
	public Handle_API_Covid19 getRef_getdatacovdi19() throws RemoteException;
	public Login_control getRef_login_check();
	public Regiser getRef_Register() throws RemoteException;


}
