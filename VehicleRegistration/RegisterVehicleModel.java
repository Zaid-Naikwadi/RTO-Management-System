package VehicleRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterVehicleModel {
		
		public byte[] fileContent;
			Connection conection;
			
			public RegisterVehicleModel()
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

		public void submit(String name,String Address,String Date,String Dealer,String DealerAddress,String VehicleType,String VehicleClass,String Company,String Model, String ChNo,String EnNo,long Phone,String Email,byte[] AadharContent,byte[] InsuranceContent,byte[] RecieptContent,byte[] ProofContent) throws SQLException{
			PreparedStatement preparedstatement = null;
				String query = "insert into Registration1 (Name,Address,DOB,Dealer,DealerAddress,VehicleType,VehicleClass,Company,Model,ChasisNo,EngineNo,Phone,Email,AadharImage,InsuranceImage,RecieptImage,ProofImage) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				preparedstatement = conection.prepareStatement(query);
				preparedstatement.setString(1,name);
				preparedstatement.setString(2,Address);
				preparedstatement.setString(3,Date);
				preparedstatement.setString(4,Dealer);
				preparedstatement.setString(5,DealerAddress);
				preparedstatement.setString(6,VehicleType);
				preparedstatement.setString(7,VehicleClass);
				preparedstatement.setString(8,Company);
				preparedstatement.setString(9,Model);
				preparedstatement.setString(10,ChNo);
				preparedstatement.setString(11,EnNo);
				preparedstatement.setLong(12,Phone);
				preparedstatement.setString(13,Email);
				preparedstatement.setBytes(14,AadharContent);
				preparedstatement.setBytes(15,InsuranceContent);
				preparedstatement.setBytes(16,RecieptContent);
				preparedstatement.setBytes(17,ProofContent);
			preparedstatement.executeUpdate();
			}
}


