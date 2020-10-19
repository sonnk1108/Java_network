package Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Model.Covid19;

public interface Handle_API_Covid19 extends Remote  {
	public Covid19 getcoviddata() throws RemoteException;

}
