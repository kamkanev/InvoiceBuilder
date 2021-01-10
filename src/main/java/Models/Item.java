package Models;

public class Item {
	
	private String name;
	private String measure;
	private double quantity;
	private double priceForOne;
	private double sum;
	
	public Item(String name, String measure, double quantity, double priceForOne) {
		this.name = name;
		this.measure = measure;
		this.quantity = quantity;
		this.priceForOne = priceForOne;
		
		this.sum = this.priceForOne * this.quantity;
	}

	public String getName() {
		return name;
	}

	public String getMeasure() {
		return measure;
	}

	public double getQuantity() {
		return quantity;
	}

	public double getPriceForOne() {
		return priceForOne;
	}

	public double getSum() {
		return sum;
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.measure + " " + this.quantity + " " + this.priceForOne;
	}
	

}
