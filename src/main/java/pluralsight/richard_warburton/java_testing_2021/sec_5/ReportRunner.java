package pluralsight.richard_warburton.java_testing_2021.sec_5;

public class ReportRunner {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("You must provide a commandline argument specifying the file to analyse");

			System.exit(-1);
		}

		final String fileLocation = args[0];

		CsvSalesRepository csvSalesRepository = new CsvSalesRepository(fileLocation);
		csvSalesRepository.setError(System.err);

		SalesAnalysisService salesAnalysisService = new SalesAnalysisService(csvSalesRepository);

		// SalesReport report = new SalesReport(System.out, args[0]);
		SalesReport report = new SalesReport(System.out, salesAnalysisService);

		report.report();
	}
}
