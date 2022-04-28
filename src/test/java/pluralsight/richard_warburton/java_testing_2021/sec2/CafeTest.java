package pluralsight.richard_warburton.java_testing_2021.sec2;

import org.junit.jupiter.api.Test;
import pluralsight.richard_warburton.java_testing_2021.sec_2_3.Cafe;
import pluralsight.richard_warburton.java_testing_2021.sec_2_3.Coffee;
import pluralsight.richard_warburton.java_testing_2021.sec_2_3.CoffeeType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CafeTest {
	// this test is conceptually about brewing Espresso
	@Test
	public void shouldBrewEspresso() {
		// PHASE #1: GIVEN
		Cafe cafe = new Cafe();

		System.out.println(
			"the number of beans before being restocked -> " +
			cafe.getBeansInStock()
		);

		// beans must be restocked in order to pass this test (7 beans or above for Espresso),
		// otherwise IllegalStateException is thrown due to insufficient beans/milk in stock
		cafe.restockBeans(7);

		System.out.println(
			"the number of beans after being restocked -> " +
			cafe.getBeansInStock()
		);

		// PHASE #2: WHEN
		Coffee brewedEspresso = cafe.brew(CoffeeType.Espresso);

		// PHASE #3: THEN
		assertEquals(7, brewedEspresso.getBeans());
		assertEquals(0, brewedEspresso.getMilk());
		assertEquals(CoffeeType.Espresso, CoffeeType.Espresso);
	}

	// this test is conceptually about stock levels
	@Test
	public void shouldUpdateStockLevels() {
		// given
		Cafe cafe = new Cafe();

		cafe.restockBeans(7);

		// when
		cafe.brew(CoffeeType.Espresso);

		// then
		assertEquals(0, cafe.getBeansInStock());
	}

	// assert an exception thrown in this test
	@Test
	public void shouldRequireBeansToBrewEspresso() {
		// given
		Cafe cafe = new Cafe();

		// then
		assertThrows(
			IllegalStateException.class,
			// when
			() -> cafe.brew(CoffeeType.Espresso)
		);
	}
}
