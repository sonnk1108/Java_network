package Controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Model.Gold;

public interface Get_Data_Gold extends Remote{
	 public ArrayList<Gold> getDB() throws RemoteException;
		 
	 

}
