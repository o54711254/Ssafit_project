package com.ssafy.fit.util;

import java.util.Scanner;

public class SsafitUtil {
	private static Scanner sc = new Scanner(System.in);
	
	private SsafitUtil() {
		
	}
	
	public static String input(String msg) {
		System.out.print(msg);
		String str = sc.next();
		return str;
	}
	
	public static int inputInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		return num;
	}
	
	public static void printLine() {
		System.out.println("--------------------------------------------");
	}
	
	public static void printLine(char ch) {
		
	}
	
	public static void printLine(char ch, int len) {}
	
	public static void screenClear() {
		for (int i = 0; i < 80; i++)
		      System.out.println("");
	}
	
	
}
