package com.ubs.opsit.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ubs.opsit.interviews.TimeConverter;

public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {

		if (!(validateTime(aTime))) {

			String error = "Please enter a valid time in HH:MM:SS format";
			System.out.println(error);
			return error;
		}

		String row1 = "0\n";
		String row2 = "0000\n";
		String row3 = "0000\n";
		String row4 = "00000000000\n";
		String row5 = "0000\n";

		StringBuilder berlinTimeFormat = new StringBuilder("");
		String[] time = aTime.split(":");

		int hh = Integer.parseInt(time[0]);
		int mm = Integer.parseInt(time[1]);
		int ss = Integer.parseInt(time[2]);

		if ((ss % 2) == 0) {
			berlinTimeFormat = berlinTimeFormat.append(row1.replace('0', 'Y'));

		} else {
			berlinTimeFormat = berlinTimeFormat.append(row1);

		}

		int quotientOfHr = hh / 5;
		int remainderOfHr = hh % 5;

		berlinTimeFormat = berlinTimeFormat.append(formatHrString(0,
				quotientOfHr, row2));

		berlinTimeFormat = berlinTimeFormat.append(formatHrString(0,
				remainderOfHr, row3));

		int quotientOfMin = mm / 5;
		int remainderOfMin = mm % 5;

		berlinTimeFormat = berlinTimeFormat.append(formatMinString(0,
				quotientOfMin, row4));

		berlinTimeFormat = berlinTimeFormat.append(formatMinString(0,
				remainderOfMin, row5));

		System.out.println("Time in Berlin Clock format: \n" + berlinTimeFormat.toString());
		return berlinTimeFormat.toString();

	}

	public String formatHrString(int start, int end, String row) {

		char[] charArray = row.toCharArray();

		for (int i = start; i < end; i++) {

			charArray[i] = 'R';
		}

		return String.valueOf(charArray);

	}

	public String formatMinString(int start, int end, String row) {

		char[] charArray = row.toCharArray();

		for (int i = start; i < end; i++) {

			if (row.length() > 5 && (i == 2 || i == 5 || i == 8)) {
				charArray[i] = 'R';
			} else {
				charArray[i] = 'Y';
			}
		}

		return String.valueOf(charArray);

	}

	public boolean validateTime(String aTime) {

		String TIME24HOURS_PATTERN = "^([0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$";

		Pattern pattern = Pattern.compile(TIME24HOURS_PATTERN);

		Matcher matcher = pattern.matcher(aTime);

		return matcher.matches();

	}

}
