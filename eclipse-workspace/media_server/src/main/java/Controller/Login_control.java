package Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Model.User;

public interface Login_control extends Remote  {
	public String check_login(User us) throws RemoteException;
}
