package pluralsight.richard_warburton.java_testing_2021.sec_6;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SalesReportSystemTest {
  // Using example: London has produced 235 sales
	@Test
	public void shouldFindExampleSalesInOutput() {
		ApplicationRunner appRunner = new ApplicationRunner();

		String output = appRunner.run("src/main/resources/example-sales.csv");

		assertThat(output, containsString("- London          -    235 -"));
	}
}
