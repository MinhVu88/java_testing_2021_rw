package pluralsight.richard_warburton.java_testing_2021.sec3;

import org.junit.jupiter.api.*;
import pluralsight.richard_warburton.java_testing_2021.sec_2_3.Cafe;
import pluralsight.richard_warburton.java_testing_2021.sec_2_3.Coffee;
import pluralsight.richard_warburton.java_testing_2021.sec_2_3.CoffeeType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CafeTest {
	private static final int ESPRESSO_BEANS_WEIGHT = 7;
	private static final int LATTE_MILK_WEIGHT = 227;

	Cafe cafe;

	@BeforeAll
	public static void start() {
		System.out.println("before all the tests");
	}

	@BeforeEach
	public void setup() {
		cafe = new Cafe();

		System.out.println("\tbefore each test");
	}

	@AfterEach
	public void teardown() {
		System.out.println("after each test");
	}

	@AfterAll
	public static void end() {
		System.out.println("after all the tests");
	}

	@Test
	public void canBrewEspresso() {
		// given
		cafe.restockBeans(ESPRESSO_BEANS_WEIGHT);

		// when
		Coffee coffee = cafe.brew(CoffeeType.Espresso);

		// then
		assertEquals(
			ESPRESSO_BEANS_WEIGHT,
			coffee.getBeans(),
			"incorrect number of beans"
		);

		assertEquals(
			0,
			coffee.getMilk(),
			"incorrect quantity of milk"
		);

		assertEquals(
			CoffeeType.Espresso,
			coffee.getType(),
			"incorrect CoffeeType"
		);
	}

	@Test
	public void brewingEspressoConsumesBeans() {
		cafe.restockBeans(ESPRESSO_BEANS_WEIGHT);

		// when
		cafe.brew(CoffeeType.Espresso);

		// then
		assertEquals(0, cafe.getBeansInStock());
	}

	@Test
	public void canBrewLatte() {
		cafe.restockBeans(ESPRESSO_BEANS_WEIGHT);

		cafe.restockMilk(LATTE_MILK_WEIGHT);

		// when
		Coffee coffee = cafe.brew(CoffeeType.Latte);

		// then
		assertEquals(CoffeeType.Latte, coffee.getType());
	}

	@Test
	public void mustRestockMilk() {
		// then
		assertThrows(
			IllegalArgumentException.class,
			() -> {
				// when
				cafe.restockMilk(0);
			}
		);
	}

	@Test
	public void mustRestockBeans() {
		// then
		assertThrows(
			IllegalArgumentException.class,
			() -> {
				// when
				cafe.restockBeans(0);
			}
		);
	}

	@Test
	public void lattesRequireMilk() {
		// given
		cafe.restockBeans(ESPRESSO_BEANS_WEIGHT);

		// then
		assertThrows(
			IllegalStateException.class,
			() -> {
				// then
				cafe.brew(CoffeeType.Latte);
			},
		"incorrectly brewed Latte"
		);
	}
}
