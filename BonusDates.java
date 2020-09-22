package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BonusDates {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) {
		printBonusDatesBetween(2010, 2015);
	}

	public static void printBonusDatesBetween(int fromYear, int toYear) {
		int month;
		int day;
		String date = "";

		for (int i = fromYear; i < toYear; i++) {
			month = getMonth(i);
			day = getDay(i);
			date = i + "-" + month + "-" + day;

			prinIfValidDate(date);
		}

	}

	public static int getMonth(int year) {
		return (year % 10) * 10 + (year / 10) % 10;
	}

	public static int getDay(int year) {
		return (year / 100) % 10 + (year / 1000) % 10;
	}

	public static void prinIfValidDate(String stringDate) {

		String formattedDate = null;
		sdf.setLenient(false);

		try {
			Date javaDate = sdf.parse(stringDate);
			formattedDate = sdf.format(javaDate);
			System.out.println(formattedDate);
		} catch (ParseException e) {
		}
	}

}
