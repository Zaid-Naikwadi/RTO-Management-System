package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
	Connection conection;
	
	public LoginModel()
	{
	conection = SqliteConnection.connector();
	}
	
	public boolean isDbConnected()
	{
		try {
			return ! conection.isClosed();
		} catch (Exception e) {
			return false;
		}
	} 
	
	public int isLogin(String user,String pass) throws SQLException
	{
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		String query = "select * from Emp where Username = ? and Password = ?";
		
		try {
			preparedstatement = conection.prepareStatement(query);
			preparedstatement.setString(1,user);
			preparedstatement.setString(2,pass);
			
			resultset = preparedstatement.executeQuery();
			
			if(user.equals(""))
			{
				return 1;
			}
			
			else if(pass.equals(""))
			{
				return 2;
			}
			
			else if(user.equals("Admin") && pass.equals("Admin123")){
				return 10;
			}
			
			else if(resultset.next()){ 
				return 3;
				}
			
			else {
			return 4;
			}
			
		} catch (Exception e) {
			return 0;
		}
		
		finally{
			preparedstatement.close();
			resultset.close();
		}		
	} 
}
