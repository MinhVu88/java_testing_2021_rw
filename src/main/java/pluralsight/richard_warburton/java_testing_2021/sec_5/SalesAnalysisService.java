package pluralsight.richard_warburton.java_testing_2021.sec_5;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class SalesAnalysisService {
	// private final String fileLocation;
	private final SalesRepository salesRepo;

	public SalesAnalysisService(final SalesRepository salesRepo /* String fileLocation */) {
		// this.fileLocation = fileLocation;
		this.salesRepo = salesRepo;
	}

	public Map<String, Integer> tallyProductSales() {
		return tallySalesBy(Sale::getProduct);
	}

	public Map<String, Integer> tallyStoreSales() {
		return tallySalesBy(Sale::getStore);
	}

	private Map<String, Integer> tallySalesBy(Function<Sale, String> classifier) {
		// CsvSalesRepository repo = new CsvSalesRepository(fileLocation);

		return this.salesRepo.loadSales()
							 .stream()
							 .collect(
								  groupingBy(
										classifier,
										summingInt(Sale::getValue)
								  )
							 );
	}
}
