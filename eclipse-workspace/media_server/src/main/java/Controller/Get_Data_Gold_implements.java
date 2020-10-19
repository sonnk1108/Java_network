package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory.Result;
import Model.Gold;
import Model.IO;

public class Get_Data_Gold_implements implements Get_Data_Gold {
	 
	 public ArrayList<Gold> getDB() {
		 IO.connect();
			ArrayList<Gold> gold = new ArrayList<>();

		 String sql="SELECT `id`, `name`, `price`, `date` FROM `XAU` ORDER BY id DESC LIMIT 10";
		 try {
			PreparedStatement smt =IO.conn.prepareStatement(sql);
			ResultSet rs= smt.executeQuery();
			while(rs.next()) {
				Gold g = new Gold(rs.getString("price"),rs.getString("date"));
				gold.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gold;
	 }
}
