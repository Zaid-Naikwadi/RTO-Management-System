package TansferVehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TransferOfVehicleModel {
		
			Connection conection;
			
			public TransferOfVehicleModel()
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

		public boolean submit(String name,String Address,String Name1,String Address1,String Date,long Phone,String Email,int rNo,byte[] AadharContent,byte[] ProofContent) throws SQLException{
			PreparedStatement preparedstatement = null;
			PreparedStatement preparedstatement1 = null;
			ResultSet rs = null;
			String query1 = "Select * from Registration1 where Rno = ?";
			preparedstatement1 = conection.prepareStatement(query1);
			preparedstatement1.setInt(1, rNo);
			rs = preparedstatement1.executeQuery();
			if(rs.next()){
				String query = "update Registration1 set Name = ?,Address = ?,DOB = ?,Phone = ?,Email = ?,AadharImage = ?,ProofImage = ? where  Rno = ?";
				preparedstatement = conection.prepareStatement(query);
				preparedstatement.setString(1,Name1);
				preparedstatement.setString(2,Address1);
				preparedstatement.setString(3,Date);
				preparedstatement.setLong(4,Phone);
				preparedstatement.setString(5,Email);
				preparedstatement.setBytes(6,AadharContent);
				preparedstatement.setBytes(7, ProofContent);
				preparedstatement.setInt(8,rNo);
			preparedstatement.executeUpdate();
			return(true);
			}
			else{
				return(false);
				
			}
				
		  }
}
