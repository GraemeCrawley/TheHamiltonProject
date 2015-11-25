
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

public class eBook extends Readable{

	public eBook(int sNo, String name, String authorName, int price, int quantity, boolean tax) { //constructors of the CDs
		super(sNo, name, authorName, price, quantity, tax);
		this.authorName = authorName;
		this.name = name;
		this.quantity = quantity;
		this.tax = tax;
	}
	protected int quantity;
	protected boolean tax;

	@Override
	public int getPrice(){
		return price;
	}
	
	public boolean getTax(){
		return tax;
	}
}