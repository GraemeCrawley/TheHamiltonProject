
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

//Changed this

public abstract class Item{
	public Item(int sNo, String name, String creator, double price, int quantity) { //constructor
		this.price = (int) Math.round(price);
		this.sNo = sNo;
	}
	public abstract String getInfo();
	public abstract int getPrice();
	protected int price;
	protected int sNo;
// Add other fields if necessary
}