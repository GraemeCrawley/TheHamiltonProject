/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
public class UserInterface {
	@SuppressWarnings("unused")
	private Array readables;
	@SuppressWarnings("unused")
	private Array audioProducts;
	private int currentPage; // the page number (P1..P10)
	public int getCurrentPage(){ //This method is for page navigation. Based on the values of the state variable, call different pages
		return currentPage;
	}
	public void changeCurrentPage(int n){// This method is for page navigation. It should change to current page and show the content.
		currentPage = n;
	}
	public void getReadables() {// Fetches all readable from the files and places them in the readable array
	}
	public void getAudioProducts(){ // Fetches all audio products from the files and places in them in the readables array
	}
	public void showReadables(){ //Displays all readable for browsing
	}
	public void showAudioProducts(){ // Displays all audio products for browsing
	}
	public static String[] readLines(String filename) throws IOException{
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null){
			lines.add(line);
			}
		bufferedReader.close();
		String[] linesArray = new String[lines.size()];
		linesArray = lines.toArray(linesArray);
		return linesArray;
		}
}