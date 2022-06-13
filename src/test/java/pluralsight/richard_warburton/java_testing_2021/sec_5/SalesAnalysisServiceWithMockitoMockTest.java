package pluralsight.richard_warburton.java_testing_2021.sec_5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SalesAnalysisServiceWithMockitoMockTest {
	private static final List<Sale> exampleSales = Arrays.asList(
		new Sale("Apples", "Cardiff", 10, 2),
		new Sale("Oranges", "Cardiff", 3, 5),
		new Sale("Bananas", "Cardiff", 6, 20),
		new Sale("Oranges", "London", 5, 7)
	);

	private static final Map<String, Integer> expectedStoreSales = new HashMap<>();

	static {
		expectedStoreSales.put("Cardiff", 155);
		expectedStoreSales.put("London", 35);
	}

	@Test
	public void shouldAggregateStoreSales() {
		// GIVEN
		SalesRepository mockRepo = mock(SalesRepository.class);

		when(mockRepo.loadSales()).thenReturn(exampleSales);

		SalesAnalysisService salesAnalysisService = new SalesAnalysisService(mockRepo);

		// WHEN
		Map<String, Integer> storeSales = salesAnalysisService.tallyStoreSales();

		// THEN
		assertEquals(
		expectedStoreSales,
		storeSales,
		"calculated wrong store sales"
		);

		verify(mockRepo).loadSales();
	}
}
