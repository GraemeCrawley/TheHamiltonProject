
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

public class Book extends Readable {
	private int sNo = 0;
	private String name = null;
	private String author = null;
	private double price = 0;
	private int quantity = 0;
		
	public Book(int parseInt, String name2, String author2, double parseDouble, int parseInt2) {
		sNo = parseInt;
		name = name2;
		author = author2;
		price = parseDouble;
		quantity = parseInt2;
	}

	@Override
	public int getPrice(){// override to get the item price and add 2% (Environment Tax)
		double tax = 0.02;
		double newPrice = price*(tax+1);
		Long L = Math.round(newPrice);
		int finalPrice = Integer.valueOf(L.intValue());
		return finalPrice;
	}
}