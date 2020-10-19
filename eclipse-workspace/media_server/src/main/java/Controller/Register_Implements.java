package Controller;

import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.IO;
import Model.User;

public class Register_Implements implements Regiser{

	@Override
	public void regiter_user(User us) throws RemoteException {
		IO.connect();
		String sql="INSERT INTO `user`(`user`, `pass`, `email`) VALUES (?,?,?)";
		try {
			PreparedStatement smt =IO.conn.prepareStatement(sql);
			smt.setString(1,us.getName());
			smt.setString(2,us.getPass());
			smt.setString(3, us.getEmail());
			int result=smt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
