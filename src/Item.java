
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

//Changed this

public abstract class Item{
	public Item(int sNo, String name, String creator, int price, int quantity, boolean tax) { //constructor
		Item.price = (int) Math.round(price);
		Item.sNo = sNo;
		Item.quantity = quantity;
	}
	public abstract String getInfo();
	public abstract int getPrice();
	protected static int price;
	protected static int sNo;
	protected static int quantity;
	protected static String Title;
	protected static Boolean tax;
	public static int getSNo(){
		return sNo;
	}
// Add other fields if necessary
	public static int getQuantity() {
		return quantity;
	}
	public static String getTitle(){
		return Title;
	}
}