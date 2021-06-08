package com.capgemini.hotelbilling.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ShowAllFoodItems {

	public static void showAllFoodItems() {
		

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbUrl = "jdbc:mysql://localhost:3307/hotel_db?user=root&password=xlr8rox";
			conn = DriverManager.getConnection(dbUrl);
						
			String query = "select * from hotel_bill";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				System.out.println();
				System.out.println("Item Code : " + rs.getInt(1));
				System.out.println("Food Name : " + rs.getString(2));
				System.out.println("Price	  : " + rs.getString(3));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
