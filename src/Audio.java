
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

public class Audio extends Item{
	
	public Audio(int sNo, String name, String artistName, int price, int quantity, boolean tax) { //constructor
		super(sNo, name, artistName, price, quantity, tax);
		this.artistName = artistName;
		this.name = name;
	}
	protected String name;
	protected String artistName;
	protected int quantity;
	public String getInfo(){
		String info =String.format("%4d%16s%16s%5d%4d", sNo, name, artistName, price);
		return info;
	}
	@Override
	public int getPrice(){
		return price;
	}
}