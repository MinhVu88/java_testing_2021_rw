package pluralsight.richard_warburton.java_testing_2021.sec_6;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Map;

import static org.mockito.Mockito.*;

public class SalesReportTest {
	private static final String STORE_LOCATION = "London";
	private static final int SALES_QUANTITY = 235;

	// a mock that verifies the result
	PrintStream mockOutput = mock(PrintStream.class);

	// salesAnalyser is a stub that provides & returns fake inputs
	SalesAnalyser salesAnalyser = mock(SalesAnalyser.class);

	SalesReport salesReport = new SalesReport(mockOutput, salesAnalyser);

	@Test
	public void shouldPrintStoreLocationAndSalesQuantity() {
		// GIVEN
		Map<String, Integer> results = Map.of(STORE_LOCATION, SALES_QUANTITY);

		when(salesAnalyser.tallyStoreSales()).thenReturn(results);

		// WHEN
		salesReport.run();

		// THEN
		verify(mockOutput).printf(anyString(), eq(STORE_LOCATION), eq(SALES_QUANTITY));
	}
}
