package PermanentLicense;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqliteConnection {
public static Connection connector()
{
	try {
		Class.forName("org.sqlite.JDBC");
		Connection conn = DriverManager.getConnection("jdbc:sqlite:PermanentDatabase.sqlite");
		return conn;
	    }
	
	catch (Exception e) {
		return null;
	}
  }

public static Connection connectorL()
{
	try {
		Class.forName("org.sqlite.JDBC");
		Connection conn1 = DriverManager.getConnection("jdbc:sqlite:LearningDatabase.sqlite");
		return conn1;
	    }
	
	catch (Exception e) {
		return null;
	}
  }
}
