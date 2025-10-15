package com.cloudblitz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	public static void main(String[] args) {

//		try {
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
//			
//			System.out.println(connection);
//			Statement statement = connection.createStatement();
//			ResultSet result = statement.executeQuery("select * from users");
//			
//			while(result.next()) {
//				System.out.println(result.getInt(1)+", "+result.getString(2)+", "+result.getString(3));
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

//		try {
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
//			
//			System.out.println(connection);
//			Statement statement = connection.createStatement();
//			int result = statement.executeUpdate("insert into users values(6, 'Satyam', 'satyam@123')");
//			System.out.println(result + " lines inserted");
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

//		try {
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
//			
//			System.out.println(connection);
//			Statement statement = connection.createStatement();
//			int result = statement.executeUpdate("delete from users where id=6");
//			System.out.println(result + " row deleted");
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
				Statement statement = connection.createStatement();) {

			int result = statement.executeUpdate("update users set name='shiv' where id=5");
			System.out.println(result + " row updated");

			// statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
