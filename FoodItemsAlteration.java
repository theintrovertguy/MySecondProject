package com.capgemini.hotelbilling.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class FoodItemsAlteration {

	public static void addItems() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		Scanner sc = new Scanner(System.in);

		try {

			// LOAD THE DRIVER

			Class.forName("com.mysql.jdbc.Driver"); // NO NEED TO INVOKE REGISTERDRIVER()

			System.out.println("Driver Loaded.");
			System.out.println("--------------------------------------------");

			// GET THE CONNECTION

			String dbUrl = "jdbc:mysql://localhost:3307/hotel_db?user=root&password=xlr8rox";
			conn = DriverManager.getConnection(dbUrl);


			System.out.println("Connection is established.");
			System.out.println("--------------------------------------------");

			// ISSUE SQL QUERY VIA CONNECTION

			String query = "INSERT INTO hotel_bill VALUES (?,?,?)";

			pstmt = conn.prepareStatement(query);

			System.out.print("Enter Item Code : ");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));

			System.out.print("Enter Food Name : ");
			pstmt.setString(2, sc.nextLine());

			System.out.print("Enter Price : ");
			pstmt.setDouble(3, Double.parseDouble(sc.nextLine()));

			int count = pstmt.executeUpdate();

			// PROCESS THE RESULT

			if (count > 0) {
				System.out.println("New Food item is inserted successfully.");
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

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//sc.close();
			}

		}
	}

	public static void removeItem() {

		Connection conn = null;
		PreparedStatement pstmt = null;

		Scanner sc = new Scanner(System.in);

		try {

			// LOAD THE DRIVER

			Class.forName("com.mysql.jdbc.Driver"); // NO NEED TO INVOKE REGISTERDRIVER()

			System.out.println("Driver Loaded.");
			System.out.println("--------------------------------------------");

			// GET THE CONNECTION

			// String dbUrl =
			// "jdbc:mysql://localhost:3307/capg_db?user=root&password=xlr8rox";
			String dbUrl = "jdbc:mysql://localhost:3307/hotel_db?user=root&password=xlr8rox";

			// conn = DriverManager.getConnection(dbUrl);
			conn = DriverManager.getConnection(dbUrl);

			System.out.println("Connection is established.");
			System.out.println("--------------------------------------------");

			// ISSUE SQL QUERY VIA CONNECTION

			String query = "DELETE FROM hotel_bill WHERE item_code = ?";

			pstmt = conn.prepareStatement(query); // Pre-compiled Query syntax stays in pstmt at first

			System.out.print("Enter Item code you want to delete: ");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));

			int count = pstmt.executeUpdate();

			// PROCESS THE RESULT

			if (count > 0) {
				System.out.println("The food item is deleted successfully.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("Sorry, Something went wrong. Try again.");
					// e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//sc.close();
			}

		}
	}

	public static void modifyItem() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		Scanner sc = new Scanner(System.in);

		try {

			// LOAD THE DRIVER

			Class.forName("com.mysql.jdbc.Driver"); // NO NEED TO INVOKE REGISTERDRIVER()

			System.out.println("Driver Loaded.");
			System.out.println("--------------------------------------------");

			// GET THE CONNECTION

			String dbUrl = "jdbc:mysql://localhost:3307/hotel_db?user=root&password=xlr8rox";
			// String dbUrl = "jdbc:mysql://localhost:3307/capg_db";

			conn = DriverManager.getConnection(dbUrl);

			System.out.println("Connection is established.");
			System.out.println("--------------------------------------------");

			// ISSUE SQL QUERY VIA CONNECTION

			String query = "UPDATE hotel_bill SET Food_name = ? , price = ? where item_code = ?";

			pstmt = conn.prepareStatement(query); // Pre-compiled Query syntax stays in pstmt at first

			System.out.print("Enter the new Food name : ");
			pstmt.setString(1, sc.nextLine());

			System.out.print("Enter the new Value : ");
			pstmt.setDouble(2, Double.parseDouble(sc.nextLine()));
			
			System.out.print("Enter Item Code for which the value to be changed : ");
			pstmt.setInt(3, Integer.parseInt(sc.nextLine()));

			int count = pstmt.executeUpdate();

			// PROCESS THE RESULT

			if (count > 0) {
				System.out.println("The value for the given food item is changed successfully.");
			}

		} catch (Exception e) {
			System.out.println("Sorry, something went wrong. Try again.");
			// e.printStackTrace();
		}

		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//sc.close();
			}

		}
	}

	public static void go() {

		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println("Press A to add food items");
		System.out.println("Press B to remove food items");
		System.out.println("Press C to modify food items");

		System.out.print("\nYour response : ");

		String response = sc.nextLine();

		switch (response) {
		case "A":

			addItems();

			break;

		case "B":
			removeItem();
			break;

		case "C":
			modifyItem();
			break;

		default:
			//sc.close();
			break;
		}
	}
}
