package Controller;

import Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import Model.IO;
public class Login_control_implement implements Login_control{

	@Override
	public String check_login(User us) {
		IO.connect();
		String result="";
		String sql="SELECT  `user`, `pass` FROM `user` WHERE user=? and pass=?";
		try {
			java.sql.PreparedStatement smt = IO.conn.prepareStatement(sql);
			smt.setString(1, us.getName());
			smt.setString(2, us.getPass());
			ResultSet rs=smt.executeQuery();
			while(rs.next()) {
				result="OK";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		System.out.print("User co ton tai");

		return result;
	}
	

}
