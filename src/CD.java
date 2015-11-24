
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

public class CD extends Audio {
	public CD(int sNo, String name, String artist, double price, int quantity) { //constructors of the CDs
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getPrice(){
		double tax = 0.02;
		double newPrice = price*(tax+1);
		Long L = Math.round(newPrice);
		int finalPrice = Integer.valueOf(L.intValue());
		return finalPrice;
	}
}