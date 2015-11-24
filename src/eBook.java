
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

public class eBook extends Readable{
	public eBook(int sNo, String name, String authorName, double price, int quantity) { //constructors of the CDs
		super(sNo, name, authorName, price, quantity);
		this.price = (int) Math.round(price);
		this.sNo = sNo;
		this.authorName = authorName;
		this.name = name;
		this.quantity = quantity;
	}
	protected int quantity;

	@Override
	public int getPrice(){ // override and only call the parent’s constructor to get the base price.
		return price;
	}
}