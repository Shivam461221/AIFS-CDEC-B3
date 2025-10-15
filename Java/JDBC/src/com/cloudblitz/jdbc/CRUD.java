package com.cloudblitz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/mydb" ;
		final String USERNAME = "root";
		final String PASSWORD = "root";
		
		final String INSERT_QUERY = "insert into users (id, name, email) values (?, ?, ?)";
		
		
		try (Connection connection = DriverManager.getConnection(URL,USERNAME ,PASSWORD );
				//Statement statement = connection.createStatement();
				PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY);
			) 
		{
			
			pstmt.setInt(1, 6);
			pstmt.setString(2, "Kuldeep");
			pstmt.setString(3, "kuldeep@123");
			int result = pstmt.executeUpdate();
			System.out.println(result + " row updated");

			// statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
