package main.java.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseReader {
	
	public String getHello() {		
		try {
			String databaseURL = "jdbc:postgresql://";
			databaseURL += System.getenv("POSTGRESQL_SERVICE_HOST");
			databaseURL += "/" + System.getenv("POSTGRESQL_DATABASE");
			String username = System.getenv("POSTGRESQL_USER");
			String password = System.getenv("POSTGRESQL_PASSWORD");
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
			return "Database connection problem!";
		}
		return "fail";
	}
}
