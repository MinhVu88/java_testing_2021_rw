package pluralsight.richard_warburton.java_testing_2021.sec3;

import pluralsight.richard_warburton.java_testing_2021.sec_2_3.Cafe;
import pluralsight.richard_warburton.java_testing_2021.sec_2_3.Coffee;
import pluralsight.richard_warburton.java_testing_2021.sec_2_3.CoffeeType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HamcrestExampleTest {
	@Test
	public void mapShouldContainValue() {
		var values = Map.of("A", 1, "B", 2);

		// terrible failure diagnostics
		// assertTrue(values.containsKey("b"));
		// assertEquals(2, values.get("b"));

		// better failure diagnostics (using hamcrest)
		// assertThat(values, hasKey("b"));
		// assertThat(values, hasEntry("b", 2));
		assertThat(values, hasEntry("B", 2));
	}

	@Test
	public void listOrderingIsIrrelevant() {
		var numbers = getNumbers();

		// not recommended
		// assertEquals(Arrays.asList(1, 2, 3, 4, 5), numbers);
		// assertEquals(Arrays.asList(5, 4, 1, 2, 3), numbers);

		// using hamcrest (recommended)
		assertThat(numbers, containsInAnyOrder(2, 4, 3, 5, 1));
	}

	private List<Integer> getNumbers() {
		return Arrays.asList(5, 4, 1, 2, 3);
	}

	@Test
	public void properties() {
		Coffee coffee = new Coffee(CoffeeType.Espresso, 7, 0);

		// this is ok (in terms of failure diagnostics)
		// assertEquals(8, coffee.getBeans(),"incorrect number of beans");

		// but can be better (in terms of failure diagnostics)
		assertThat(coffee, hasProperty("beans", is(7)));
	}

	@Test
	public void composition() {
		var coffees  = List.of(
			new Coffee(CoffeeType.Espresso, 7, 0),
			new Coffee(CoffeeType.FilterCoffee, 10, 0)
		);

		assertThat(
			coffees,
			containsInAnyOrder(
				hasProperty("beans", is(10)),
				hasProperty("beans", is(7))
			)
		);
	}
}
