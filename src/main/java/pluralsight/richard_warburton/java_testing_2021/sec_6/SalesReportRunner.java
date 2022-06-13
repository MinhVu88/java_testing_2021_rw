package pluralsight.richard_warburton.java_testing_2021.sec_6;

import java.io.PrintStream;

public class SalesReportRunner {
	public static void main(String[] args)
	{
		run(args, System.out);
	}

	public static void run(String[] args, PrintStream output) {
		String fileLocation = args[0];

		SalesRepository salesRepository = new SalesRepository(fileLocation);

		SalesAnalyser salesAnalyser = new SalesAnalyser(salesRepository);

		SalesReport salesReport = new SalesReport(output, salesAnalyser);

		salesReport.run();
	}
}
