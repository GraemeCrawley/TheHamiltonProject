
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

public class Book extends Readable {
	@Override
	public int getPrice(){// override to get the item price and add 2% (Environment Tax)
		int k = 5;
		return k;
	}
}