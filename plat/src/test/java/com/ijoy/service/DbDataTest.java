package com.ijoy.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DbDataTest {
	public static void main(String[] args) {
		
		String url="jdbc:oracle:thin:@//localhost:1521/orcl";
		String user="white";
		String password="white";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement s = connection.createStatement();
			ResultSet resultSet = s.executeQuery("select id from logininfo");
			while (resultSet.next()) {
				System.out.println(resultSet.getLong(1));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
