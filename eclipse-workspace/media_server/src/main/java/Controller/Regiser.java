package Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Model.User;

public interface Regiser extends Remote {
	public void regiter_user(User us) throws RemoteException;

}
