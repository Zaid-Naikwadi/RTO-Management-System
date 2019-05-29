package LearningLicense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LearningModel {
	public byte[] fileContent;
		Connection conection;
		
		public LearningModel()
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

	public void submit(String name,String Parent,String Address,String Date,String Place,String Qualification,String Blood,long Phone,String Email,byte[] AadharContent,byte[] RationContent,byte[] LCContent,byte[] PhotoContent) throws SQLException{
		PreparedStatement preparedstatement = null;
		String query = "insert into Learning (Name,Parent,Address,DOB,Place,Qualification,Blood,Phone,Email,AadharImage,RationImage,LCImage,PhotoImage) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedstatement = conection.prepareStatement(query);
			preparedstatement.setString(1,name);
			preparedstatement.setString(2,Parent);
			preparedstatement.setString(3,Address);
			preparedstatement.setString(4,Date);
			preparedstatement.setString(5,Place);
			preparedstatement.setString(6,Qualification);
			preparedstatement.setString(7,Blood);
			preparedstatement.setLong(8,Phone);
			preparedstatement.setString(9,Email);
			preparedstatement.setBytes(10,AadharContent);
			preparedstatement.setBytes(11,RationContent);
			preparedstatement.setBytes(12,LCContent);
			preparedstatement.setBytes(13,PhotoContent);
		preparedstatement.executeUpdate();	
	  }
	
	public void submit1(String name,String Parent,String Address,String Date,String Place,String Qualification,String Blood,long Phone,String Email,byte[] AadharContent,byte[] LCContent,byte[] PanContent,byte[] PhotoContent) throws SQLException{
		PreparedStatement preparedstatement = null;
		String query = "insert into Learning (Name,Parent,Address,DOB,Place,Qualification,Blood,Phone,Email,AadharImage,LCImage,PanImage,PhotoImage) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedstatement = conection.prepareStatement(query);
			preparedstatement.setString(1,name);
			preparedstatement.setString(2,Parent);
			preparedstatement.setString(3,Address);
			preparedstatement.setString(4,Date);
			preparedstatement.setString(5,Place);
			preparedstatement.setString(6,Qualification);
			preparedstatement.setString(7,Blood);
			preparedstatement.setLong(8,Phone);
			preparedstatement.setString(9,Email);
			preparedstatement.setBytes(10,AadharContent);
			preparedstatement.setBytes(11,LCContent);
			preparedstatement.setBytes(12,PanContent);
			preparedstatement.setBytes(13,PhotoContent);
		preparedstatement.executeUpdate();	
	  }
	}
