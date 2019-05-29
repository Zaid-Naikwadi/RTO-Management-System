package Registered;

import java.sql.Connection;


public class LearningLicenseModel {
	public byte[] fileContent;
		Connection conection;
		
		public LearningLicenseModel()
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

	/*public void submit(int id) throws SQLException{
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		String query = "Select Name,PhototImage from Learning where ID = ?";
		preparedstatement = conection.prepareStatement(query);
		preparedstatement.setInt(1,id);
		resultset = preparedstatement.executeQuery();
		if(resultset.next()){ 
			String name = resultset.getString("Name");
			byte[] img = resultset.getBytes("PhotoImage");
			
		}
	  }*/
	}



