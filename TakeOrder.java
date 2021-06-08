package com.capgemini.hotelbilling.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.hotelbilling.bean.FoodItems;;

public class TakeOrder {

	static Scanner scanner = new Scanner(System.in);
	public static ArrayList<FoodItems> orderlists = new ArrayList<FoodItems>();

	public static void addFoodItem(int itemCode) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		FoodItems confirmedItem = new FoodItems();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String dbUrl = "jdbc:mysql://localhost:3307/hotel_db?user=root&password=xlr8rox";
			conn = DriverManager.getConnection(dbUrl);

			String query = "select * from hotel_bill where item_code = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemCode);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				confirmedItem.setItemCode(Integer.parseInt(rs.getString(1)));
				confirmedItem.setFoodName(rs.getString(2));
				confirmedItem.setPrice(rs.getDouble(3));

				orderlists.add(confirmedItem);
				
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

	public static void takeOrderMethod() {

		int orderedItemCode = 1;

		while (orderedItemCode != 0) {
			System.out.print("\nEnter the Item codes you want to purchase : ");
			orderedItemCode = scanner.nextInt();
			addFoodItem(orderedItemCode);
		}

		if (orderedItemCode == 0) {

			double total = 0;

			
			for (FoodItems f : orderlists) {

				System.out.println();
				System.out.println("Item Code  : " + f.getItemCode());
				System.out.println("Food Name  : " + f.getFoodName());
				System.out.println("Food Price : " + f.getPrice());

				total = total + f.getPrice();
			}

			System.out.println(total);
			FinalDailyBill.sendForTotal(total);
			
			orderlists.clear();
			
			//scanner.close();
		}
	}
}
