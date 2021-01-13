package Models;

import java.time.LocalDate;

public class Invoice {
	
	private String number;
	private LocalDate date;
	private LocalDate taxDate;
	private String place;
	
	private Seller seller;
	private Receiver receiver;
	
	private Content content;
	
	private String paymentType;
	

	public Invoice(String number, LocalDate date, LocalDate taxDate, String place, Seller seller, Receiver receiver,
			Content content, String paymentType) {
		this.number = number;
		this.date = date;
		this.taxDate = taxDate;
		this.place = place;
		this.seller = seller;
		this.receiver = receiver;
		this.content = content;
		this.paymentType = paymentType;
	}

	public String getNumber() {
		return number;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalDate getTaxDate() {
		return taxDate;
	}

	public String getPlace() {
		return place;
	}

	public Seller getSeller() {
		return seller;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public Content getContent() {
		return content;
	}

	public String getPaymentType() {
		return paymentType;
	}
	
	

}
