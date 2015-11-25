
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

public class Book extends Readable {
	public Book(int sNo, String name, String authorName, int price, int quantity) { //constructors of the CDs
		super(sNo, name, authorName, price, quantity);
		this.price = (int) Math.round(price);
		this.sNo = sNo;
		this.authorName = authorName;
		this.name = name;
		this.quantity = quantity;
	}
	protected int quantity;
	@Override
	public int getPrice(){// override to get the item price and add 2% (Environment Tax)
		double tax = 0.1;
		double newPrice = price*(tax+1);
		Long L = Math.round(newPrice);
		int finalPrice = Integer.valueOf(L.intValue());
		return finalPrice;
	}
}