package com.capgemini.hotelbilling.controller;

import java.util.ArrayList;

public class FinalDailyBill {
	
	static ArrayList<Double> finalbill = new ArrayList<Double>();

	public static void sendForTotal(double total) {
		
		//System.out.println(total);
		
		finalbill.add(total);
	}
	
	public static void viewFinalBill() {
		
		int count = 1;
		double dailytotal = 0;
		
		System.out.println("All the purchases today :");
		
		for (Double d : finalbill) {
			
			dailytotal = dailytotal + d;
			System.out.println(d);
			count++;
		}
		
		System.out.println("Grand total = Rs. " + dailytotal);
	}
	
}
