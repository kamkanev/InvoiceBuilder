package Models;

public class Receiver {
	
	private String name;
	private String address;
	private int eik;
	private String mol;
	private String receiverName;
	
	private String vat;

	public Receiver(String name, String address, int eik, String mol, String receiverName, String vat) {
		this.name = name;
		this.address = address;
		this.eik = eik;
		this.mol = mol;
		this.receiverName = receiverName;
		this.vat = vat;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setEik(int eik) {
		this.eik = eik;
	}


	public void setMol(String mol) {
		this.mol = mol;
	}


	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}


	public void setVat(String vat) {
		this.vat = vat;
	}
	
	@Override
	public String toString() {
		String str = "";
		
		str+= this.name;
		str += "\n";
		str+= this.receiverName;
		str += "\n";
		str+= this.address;
		str += "\n"+this.eik;
		str += "\n";
		str += this.vat;
		str += "\n";
		str += this.mol;
		str += "\n";
		
		return str;
	}
	

}
