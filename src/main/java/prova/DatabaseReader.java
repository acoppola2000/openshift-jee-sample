package prova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseReader {
	
	public String getHello() {		
		try {
			
			String databaseURL = "jdbc:postgresql://";
			//OPENSHIFT_POSTGRESQL_DB_HOST 
			//OPENSHIFT_POSTGRESQL_DB_PORT 
			//jdbc:postgresql://host:port/database			
			
			databaseURL += System.getenv("OPENSHIFT_POSTGRESQL_DB_HOST") +":" + System.getenv("OPENSHIFT_POSTGRESQL_DB_PORT");
			databaseURL += "/" + System.getenv("POSTGRESQL_DATABASE");
			String username = System.getenv("POSTGRESQL_USER_NEW");
			String password = System.getenv("POSTGRESQL_PASSWORD");
	    	System.out.println("databaseURL" + databaseURL +";");
	    	System.out.println("username" + username +";");
	    	System.out.println("password" + password +";");
			
			Connection connection = DriverManager.getConnection(databaseURL, username,password);
			if (connection != null) {
				String SQL = "select * from films limit 1";
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(SQL);
				String nomeFilm = "nessuno";
				while (rs.next()) {
					nomeFilm = rs.getString("title"); 
					//rs.getString("first"), rs.getString("second"), rs.getString("noun"));
				}
				rs.close();
				connection.close();
				return nomeFilm;
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return "Database connection problem!";
		}
		return "fail";
	}
}
