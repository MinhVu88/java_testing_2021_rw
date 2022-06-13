package pluralsight.richard_warburton.java_testing_2021.sec_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
	- A year is a leap year if it is divisible by 4 or 400.
	- Years divisible by 100 are not leap years.
*/

public class LeapYearTest {
	@Test
	public void leapYearIsDivisibleBy4() {
		assertTrue(LeapYear.isLeapYear(2020));
	}

	@Test
	public void nonLeapYearIsNotDivisibleBy4() {
		assertFalse(LeapYear.isLeapYear(2019));
	}

	@Test
	public void yearDivisibleBy100IsNotLeapYear() {
		assertFalse(LeapYear.isLeapYear(1900));
	}

	@Test
	public void yearDivisibleBy400IsLeapYear() {
		assertTrue(LeapYear.isLeapYear(2000));
	}
}
