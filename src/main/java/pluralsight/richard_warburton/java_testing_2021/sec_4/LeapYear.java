package pluralsight.richard_warburton.java_testing_2021.sec_4;

public class LeapYear {
	public static boolean isLeapYear(final int year) {
		return isDivisible(year, 4) && (!isDivisible(year, 100) || isDivisible(year, 400));
	}

	private static boolean isDivisible(int year, int denominator) {
		return year % denominator == 0;
	}
}
