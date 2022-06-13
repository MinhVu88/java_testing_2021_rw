package pluralsight.richard_warburton.java_testing_2021.sec_6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SalesRepositoryTest {
	@Test
	public void shouldLoadSampleData() {
		SalesRepository salesRepository = new SalesRepository("src/main/resources/example-sales.csv");

		List<Sale> sales = salesRepository.loadSales();

		assertThat(
			sales,
			hasItem(
				allOf(
					hasProperty("store", equalTo("London")),
					hasProperty("number", equalTo(2)),
					hasProperty("pricePerItem", equalTo(30))
				)
			)
		);
	}
}
