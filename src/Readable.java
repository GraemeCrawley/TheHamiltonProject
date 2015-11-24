
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

public class Readable extends Item {
	public Readable(int sNo, String name, String artistName, double price, int quantity) { //constructor
		super(sNo, name, artistName, price, quantity);
		this.price = (int) Math.round(price);
		this.sNo = sNo;
		this.authorName = artistName;
		this.name = name;
	}
	protected String name;
	protected String authorName;
	public String getInfo(){
		String info =String.format("%4d%16s%16s%5d%4d", sNo, name, authorName, price);
		return info;
	}
	@Override
	public int getPrice(){
		int a = 1;
		return a;
	}
}
