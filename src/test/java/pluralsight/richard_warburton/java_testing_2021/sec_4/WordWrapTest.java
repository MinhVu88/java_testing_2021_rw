package pluralsight.richard_warburton.java_testing_2021.sec_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordWrapTest {
	public static final int LINE_LENGTH = 5;

	@Test
	public void shortLinesShouldNotWrap() {
		final String result = WordWrap.wrap("the", LINE_LENGTH);

		assertEquals("the", result);
	}

	@Test
	public void wrapLineIfOverLineLength() {
		final String result = WordWrap.wrap("the sleepy", LINE_LENGTH);

		assertEquals("the s\nleepy", result);
	}

	@Test
	public void longLinesShouldWrapTwice() {
		final String result = WordWrap.wrap("the sleepy brow", LINE_LENGTH);

		assertEquals("the s\nleepy\n brow", result);
	}

	@Test
	public void longerLinesShouldWrapTwice() {
		final String result = WordWrap.wrap("the sleepy brown fox", LINE_LENGTH);

		assertEquals("the s\nleepy\n brow\nn fox", result);
	}

	@Test
	public void longLinesDontHaveToBeMultipleOfLineLength() {
		final String result = WordWrap.wrap("the sleepy brown fox.", LINE_LENGTH);

		assertEquals("the s\nleepy\n brow\nn fox\n.", result);
	}
}
