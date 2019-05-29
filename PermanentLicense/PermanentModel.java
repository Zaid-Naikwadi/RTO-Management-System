package PermanentLicense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PermanentModel {
	
	public byte[] fileContent;
		Connection conection;
		Connection LearningConnection;
		
		public PermanentModel()
		{
		conection = SqliteConnection.connector();
		LearningConnection = SqliteConnection.connectorL();
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

	public boolean submit(String name,String Address,String Date,String Place,String Qualification,String Blood,long Phone,String Email,String COV,int LLID,byte[] AadharContent,byte[] RationContent,byte[] LCContent,byte[] PhotoContent) throws SQLException{
		PreparedStatement preparedstatement = null;
		PreparedStatement preparedstatement1 = null;
		ResultSet rs = null;
		String query1 = "Select * from Learning where ID = ?";
		preparedstatement1 = LearningConnection.prepareStatement(query1);
		preparedstatement1.setInt(1, LLID);
		rs = preparedstatement1.executeQuery();
		if(rs.next()){
			String query = "insert into Permanent (Name,Address,DOB,Place,Qualification,Blood,Phone,Email,LLID,AadharImage,RationImage,LCImage,PhotoImage,COV) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedstatement = conection.prepareStatement(query);
			preparedstatement.setString(1,name);
			preparedstatement.setString(2,Address);
			preparedstatement.setString(3,Date);
			preparedstatement.setString(4,Place);
			preparedstatement.setString(5,Qualification);
			preparedstatement.setString(6,Blood);
			preparedstatement.setLong(7,Phone);
			preparedstatement.setString(8,Email);
			preparedstatement.setInt(9,LLID);
			preparedstatement.setBytes(10,AadharContent);
			preparedstatement.setBytes(11,RationContent);
			preparedstatement.setBytes(12,LCContent);
			preparedstatement.setBytes(13,PhotoContent);
			preparedstatement.setString(14, COV);
		preparedstatement.executeUpdate();
		return(true);
		}
		else{
			return(false);
			
		}
			
	  }
	
	public boolean submit1(String name,String Address,String Date,String Place,String Qualification,String Blood,long Phone,String Email,String COV,int LLID,byte[] AadharContent,byte[] LCContent,byte[] PanContent,byte[] PhotoContent) throws SQLException{
		PreparedStatement preparedstatement = null;
		PreparedStatement preparedstatement1 = null;
		ResultSet rs = null;
		String query1 = "Select * from Learning where ID = ?";
		preparedstatement1 = LearningConnection.prepareStatement(query1);
		preparedstatement1.setInt(1, LLID);
		rs = preparedstatement1.executeQuery();
		if(rs.next()){
		String query = "insert into Permanent (Name,Address,DOB,Place,Qualification,Blood,Phone,Email,LLID,AadharImage,LCImage,PanImage,PhotoImage,COV) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedstatement = conection.prepareStatement(query);
			preparedstatement.setString(1,name);
			preparedstatement.setString(2,Address);
			preparedstatement.setString(3,Date);
			preparedstatement.setString(4,Place);
			preparedstatement.setString(5,Qualification);
			preparedstatement.setString(6,Blood);
			preparedstatement.setLong(7,Phone);
			preparedstatement.setString(8,Email);
			preparedstatement.setInt(9,LLID);
			preparedstatement.setBytes(10,AadharContent);
			preparedstatement.setBytes(11,LCContent);
			preparedstatement.setBytes(12,PanContent);
			preparedstatement.setBytes(13,PhotoContent);
			preparedstatement.setString(14, COV);
		preparedstatement.executeUpdate();	
		return(true);
		}
		else{
			return(false);
		}
	  }
	}
