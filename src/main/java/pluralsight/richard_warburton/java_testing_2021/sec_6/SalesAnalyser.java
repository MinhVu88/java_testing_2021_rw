package pluralsight.richard_warburton.java_testing_2021.sec_6;

import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class SalesAnalyser {
	private final SalesRepository salesRepository;

	public SalesAnalyser(SalesRepository salesRepository)
	{
		this.salesRepository = salesRepository;
	}

	public Map<String, Integer> tallyStoreSales() {
		return salesRepository.loadSales()
												  .stream()
												  .collect(
														groupingBy(
															Sale::getStore,
															summingInt(Sale::getValue)
														)
												  );
	}
}
