package Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Model.JsonResult;

public interface Handle_API_ThoiTiet extends Remote{
	public  JsonResult getJsonData(String city) throws RemoteException;

}
