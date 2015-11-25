
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

public class MP3 extends Audio{
	
	public MP3(int sNo, String name, String artistName, int price, int quantity, boolean tax) { //constructors of the CDs
		super(sNo, name, artistName, price, quantity, tax);
		this.artistName = artistName;
		this.name = name;
		this.quantity = quantity;
		this.tax = tax;
	}
	protected int quantity;
	protected boolean tax;
	@Override
	public int getPrice(){
		double tax = 0.02;
		double newPrice = price*(tax+1);
		Long L = Math.round(newPrice);
		int finalPrice = Integer.valueOf(L.intValue());
		return finalPrice;
	}
	
	public boolean getTax(){
		return tax;
	}
}