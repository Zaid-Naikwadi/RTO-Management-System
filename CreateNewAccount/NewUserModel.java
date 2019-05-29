package CreateNewAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import application.SqliteConnection;


public class NewUserModel {
	
	Connection conection;
	
	public NewUserModel()
	{
	conection = SqliteConnection.connector();
	}
	
	public boolean isDbConnected()
	{
		try {
			return ! conection.isClosed();
		} 
		catch (Exception e) {
			return false;
		}
	}	


public void register(String name,String DOB,int age,String gender,String email,String username,String password) throws SQLException{
	PreparedStatement preparedstatement = null;
	String query = "insert into Emp (Name,DOB,Age,Gender,Email,Username,Password) values (?,?,?,?,?,?,?)";
		preparedstatement = conection.prepareStatement(query);
		preparedstatement.setString(1,name);
		preparedstatement.setString(2,DOB);
		preparedstatement.setInt(3,age);
		preparedstatement.setString(4,gender);
		preparedstatement.setString(5,email);
		preparedstatement.setString(6,username);
		preparedstatement.setString(7,password);
		
		preparedstatement.executeUpdate();	
  }
}
