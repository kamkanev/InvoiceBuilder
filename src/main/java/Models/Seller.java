package Models;

public class Seller {
	
	private String name;
	private String address;
	private int eik;
	private String mol;
	
	private String vat;
	private String bank;
	private String iban;
	private String bic;
	
	public Seller(String name, String address, int eik, String mol, String vat, String bank, String iban, String bic) {
		super();
		this.name = name;
		this.address = address;
		this.eik = eik;
		this.mol = mol;
		this.vat = vat;
		this.bank = bank;
		this.iban = iban;
		this.bic = bic;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getEik() {
		return eik;
	}

	public String getMol() {
		return mol;
	}

	public String getVat() {
		return vat;
	}

	public String getBank() {
		return bank;
	}

	public String getIban() {
		return iban;
	}

	public String getBic() {
		return bic;
	}

}
