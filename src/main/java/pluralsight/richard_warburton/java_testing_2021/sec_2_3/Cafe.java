package pluralsight.richard_warburton.java_testing_2021.sec_2_3;

// A coffee shop that can brew coffee and maintains an internal stock of beans and milk.
public class Cafe {
	private int beansInStock = 0;
	private int milkInStock = 0;

	public Coffee brew(CoffeeType coffeeType) {
		return brew(coffeeType, 1);
	}

	public Coffee brew(CoffeeType coffeeType, int strength) {
		requirePositive(strength);

		int requiredBeans = coffeeType.getRequiredBeans() * strength;
		int requiredMilk = coffeeType.getRequiredMilk() * strength;

		if (requiredBeans > beansInStock || requiredMilk > milkInStock) {
			throw new IllegalStateException();
		}

		beansInStock -= requiredBeans;
		milkInStock -= requiredMilk;

		return new Coffee(coffeeType, requiredBeans, requiredMilk);
	}

	public void restockBeans(int weightInGrams) {
		requirePositive(weightInGrams);

		beansInStock += weightInGrams;
	}

	public void restockMilk(int weightInGrams) {
		requirePositive(weightInGrams);

		milkInStock += weightInGrams;
	}

	private void requirePositive(int value) {
		if (value < 1) {
			throw new IllegalArgumentException();
		}
	}

	public int getBeansInStock() {
		return beansInStock;
	}

	public int getMilkInStock() {
		return milkInStock;
	}
}
