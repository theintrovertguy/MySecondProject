package com.capgemini.hotelbilling.controller;

import java.util.Scanner;

public class Final {

	public static void main(String[] args) {

		while (true) {

			int response;

			System.out.println();
			System.out.println("Press 1 to show all food items.");
			System.out.println("Press 2 to take orders from customers.");
			System.out.println("Press 3 to operate on food items.");
			System.out.println("Press 4 to show total bill of the day.");

			System.out.print("\nYour response : ");

			Scanner sc = new Scanner(System.in);

			response = sc.nextInt();

			switch (response) {

			case 1:
				ShowAllFoodItems.showAllFoodItems();
				break;

			case 2:
				TakeOrder.takeOrderMethod();
				break;

			case 3:
				FoodItemsAlteration.go();
				break;

			case 4:
				FinalDailyBill.viewFinalBill();
				break;

			default:
				System.out.println("You entered wrong value. Try again.");
				break;
			}
		}
	}
}
