package pluralsight.richard_warburton.java_testing_2021.sec_5;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Map;

public class SalesReport {
	private final PrintStream output;
	private final SalesAnalysisService salesAnalysisService;

	public SalesReport(
		PrintStream output,
		SalesAnalysisService salesAnalysisService
		/* String fileLocation */
	) {
		this.output = output;

		// this.analyser = new SalesAnalysisService(salesRepo, fileLocation);
		this.salesAnalysisService = salesAnalysisService;
	}

	public void report() {
		output.printf("\nSales Report for %s\n%n", LocalDate.now());

		printTable("Store Sales", salesAnalysisService.tallyStoreSales());
		printTable("Product Sales", salesAnalysisService.tallyProductSales());
	}

	private void printTable(String title, Map<String, Integer> values) {
		output.printf("---------- %s ----------%n", title);

		printRow(title, "Value");

		values.forEach((key, value) -> printRow(key, "" + value));

		output.println();
		output.println();
	}

	private void printRow(String first, String second) {
		output.printf("- %-15s - %6.6s -%n", first, second);
	}
}
