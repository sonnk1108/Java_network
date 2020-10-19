package LoginClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;



public class TestDB {
	 public static Connection con;
	   

	    public static void main(String[] args) {
	    	User user = new User("admin","12344321");
	    
			String dbClass="com.mysql.jdbc.Driver";
			try {
				Class.forName(dbClass);

	            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");


			}catch(Exception ex) {
				ex.getStackTrace();
			}	
			String query="SELECT `username`, `password` FROM `user` WHERE username= ? AND password=?;";
			try {
				PreparedStatement stmt= con.prepareStatement(query);
				stmt.setString(1,user.getUserName());
				stmt.setString(2,user.getPassword());
				ResultSet rs =stmt.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    }
}
