package Models;

import java.time.LocalDate;
import java.util.Date;

public class Invoice {
	
	private String number;
	private Date date;
	private Date taxDate;
	private String place;
	private Receiver receiver;
	
	private Content content;
	
	private String paymentType;
	

	public Invoice(String number, Date date, Date taxDate, String place, Receiver receiver,
			Content content, String paymentType) {
		this.number = number;
		this.date = date;
		this.taxDate = taxDate;
		this.place = place;
		this.receiver = receiver;
		this.content = content;
		this.paymentType = paymentType;
	}

	public String getNumber() {
		return number;
	}

	public Date getDate() {
		return date;
	}

	public Date getTaxDate() {
		return taxDate;
	}

	public String getPlace() {
		return place;
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
	
	@Override
	public String toString() {
		String str = "";
		str+= number;
		str+="\n";
		str+= place;
		str+="\n";
		str+= date;
		str+="\n";
		str+= paymentType;
		str+="\n#\n";
		str+=receiver;
		str+=content;
		return str;
	}
	

}
