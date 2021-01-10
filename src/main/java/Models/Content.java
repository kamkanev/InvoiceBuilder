package Models;

import java.util.List;

public class Content {
	
	private List<Item> items;
	private double vatProzent = 0;
	private double summary = 0;
	
	
	private String sumWithLatters = "";

	public Content(List<Item> items, double vatProzent) {
		this.items = items;
		this.vatProzent = vatProzent;
		this.summary = calculateSummaryPrice(0);
	}
	
	private double calculateSummaryPrice(double sum) {
		
		sum+=calculateItemsPrice(sum);
		sum+= calculateWithVat(sum);
	
		return sum;
	}
	
	private double calculateItemsPrice(double sum) {
		for (Item item : items) {
			sum += item.getSum();
		}
		
		return sum;
		
	}
	
	private double calculateWithVat(double sum) {
		
		return sum*(this.vatProzent/100);
		
	}
	
	public double getSummaryWithOutVat() {
		return calculateItemsPrice(0);
	}
	
	public double getSummaryWithVat() {
		return summary;
	}
	
	public double getVatSummary() {
		return calculateWithVat(calculateItemsPrice(0));
	}

	public String getSumWithLatters() {
		return sumWithLatters;
	}

	public void setSumWithLatters(String sumWithLatters) {
		this.sumWithLatters = sumWithLatters;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("#");
		for(Item item : items) {
			sb.append(System.getProperty("line.separator"));
			sb.append(item);
		}
		sb.append("\n#\n");
		sb.append(vatProzent);
		sb.append(System.getProperty("line.separator"));
		sb.append(sumWithLatters);
		
		return sb.toString();
	}

}
