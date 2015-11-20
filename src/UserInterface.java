/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

import java.lang.reflect.Array;
public class UserInterface {
	@SuppressWarnings("unused")
	private Array readables;
	@SuppressWarnings("unused")
	private Array audioProducts;
	@SuppressWarnings("unused")
	private int currentPage; // the page number (P1..P10)
	public int getCurrentPage(){ //This method is for page navigation. Based on the values of the state variable, call different pages
		return 2;
	}
	public int changeCurrentPage(){// This method is for page navigation. It should change to current page and show the content.
		return 3;
	}
	public void getReadables() {// Fetches all readable from the files and places them in the readable array
	}
	public void getAudioProducts(){ // Fetches all audio products from the files and places in them in the readables array
	}
	public void showReadables(){ //Displays all readable for browsing
	}
	public void showAudioProducts(){ // Displays all audio products for browsing
	}
}