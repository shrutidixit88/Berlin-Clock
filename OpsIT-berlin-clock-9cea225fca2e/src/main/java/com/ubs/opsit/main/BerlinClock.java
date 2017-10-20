package com.ubs.opsit.main;

import java.util.Scanner;

import com.ubs.opsit.impl.TimeConverterImpl;

public class BerlinClock {

	public static void main(String[] args) {

		TimeConverterImpl timeConverter = new TimeConverterImpl();
		System.out.println("Enter the Time (HH:MM:SS) : ");
		Scanner scanner = new Scanner(System.in);
		String aTime = scanner.nextLine();

		timeConverter.convertTime(aTime);
	}

}
