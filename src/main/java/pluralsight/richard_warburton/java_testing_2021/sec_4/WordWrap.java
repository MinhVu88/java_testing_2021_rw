package pluralsight.richard_warburton.java_testing_2021.sec_4;

public class WordWrap {
	public static String wrap(final String input, final int maxLineLength) {
		final StringBuilder accumulator = new StringBuilder();
		final int inputLength = input.length();

		// accumulator.append(input, 0, maxLineLength);
		accumulator.append(
			input,
			0,
			Math.min(inputLength, maxLineLength)
		);

		/*
		int splitPoint = maxLineLength;
		if(inputLength > splitPoint) {
			accumulator.append('\n');

			// accumulator.append(input, maxLineLength, inputLength);
			accumulator.append(
				input,
				splitPoint,
				splitPoint + maxLineLength
			);
		}

		splitPoint += maxLineLength;
		if(inputLength > splitPoint) {
			accumulator.append('\n');

			// ety
			accumulator.append(
				input,
				splitPoint,
				inputLength
			);
		}
		*/

		int splitPoint = maxLineLength;

		while(inputLength > splitPoint) {
			accumulator.append('\n');

			accumulator.append(
				input,
				splitPoint,
				Math.min(inputLength, splitPoint + maxLineLength)
			);

			splitPoint += maxLineLength;
		}

		return accumulator.toString();
	}
}
