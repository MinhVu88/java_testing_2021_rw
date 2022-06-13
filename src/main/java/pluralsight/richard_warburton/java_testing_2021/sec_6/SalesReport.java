package pluralsight.richard_warburton.java_testing_2021.sec_6;

import java.io.PrintStream;

public class SalesReport {
	private final PrintStream output;
	private final SalesAnalyser salesAnalyser;

	public SalesReport(final PrintStream output, SalesAnalyser salesAnalyser) {
		this.output = output;
		this.salesAnalyser = salesAnalyser;
	}

	public void run() {
		salesAnalyser.tallyStoreSales()
								 .forEach(
								    (storeLocation, salesQuantity) -> output.printf("- %-15s - %6.6s -%n", storeLocation, salesQuantity)
								 );
	}
}
