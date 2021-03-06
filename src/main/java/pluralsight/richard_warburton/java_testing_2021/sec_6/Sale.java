package pluralsight.richard_warburton.java_testing_2021.sec_6;

public class Sale {
	private final String store;
	private final int number;
	private final int pricePerItem;

	public Sale(String store, int number, int pricePerItem) {
		this.store = store;
		this.number = number;
		this.pricePerItem = pricePerItem;
	}

	public int getPricePerItem() {
		return pricePerItem;
	}

	public int getNumber() {
		return number;
	}

	public String getStore() {
		return store;
	}

	public int getValue() {
		return getNumber() * getPricePerItem();
	}

	@Override
	public String toString() {
		return "store: " + store + " | number: " + number + " | price per item: " + pricePerItem;
	}
}