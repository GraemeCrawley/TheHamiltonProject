
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

public class CD extends Audio {
	
	public CD(int sNo, String name, String artistName, int price, int quantity, boolean tax) { //constructors of the CDs
		super(sNo, name, artistName, price, quantity, tax);
		this.artistName = artistName;
		this.name = name;
		this.quantity = quantity;
		this.tax = tax;
	}
	protected int quantity;
	protected boolean tax;
	
	
	public int getPrice(){
		return price;
	}
	
	public boolean getTax(){
		return tax;
/*
		double tax = 0.1;
		double newPrice = price*(tax+1);
		Long L = Math.round(newPrice);
		int finalPrice = Integer.valueOf(L.intValue());
		return finalPrice;
*/
	}
}