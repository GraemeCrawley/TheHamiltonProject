
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

public class eBook extends Readable{
	@Override
	public int getPrice(){ // override and only call the parent’s constructor to get the base price.
		int p = 9;
		return p;
	}
}