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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class UserInterface {
	@SuppressWarnings("unused")
	private Array[] readables;
	@SuppressWarnings("unused")
	private Array audioProducts;
	public static Book[] bookArray;
	public static eBook[] eBookArray;
	public static CD[] CDArray;
	public static MP3[] MP3Array;
	private int currentPage;// the page number (P1..P10)
	public int getCurrentPage(){ //This method is for page navigation. Based on the values of the state variable, call different pages
		return currentPage;
	}
	public void changeCurrentPage(int n){// This method is for page navigation. It changes to current page and show the content.
		currentPage = n;
	}

	public Readable[] getReadables() throws IOException {// Fetches all readable from the files and places them in the readable array
		String[] eBookInfo = readLines("Ebooks.txt");
		eBook[] eBookArray = new eBook[eBookInfo.length];
		for (int j = 0; j< eBookInfo.length; j++){
			String item = eBookInfo[j];
			String[] tempArray = item.split(", ");
			eBookArray[j] = new eBook(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]),false);
		}
		String[] bookInfo = readLines("Books.txt"); //separates lines into strings in an array
		Book[] bookArray = new Book[bookInfo.length];
		for (int i = 0; i < bookInfo.length; i++){ 
			String item = bookInfo[i]; 
			String[] tempArray = item.split(", ");
			bookArray[i] = new Book(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]),true);
			}
		Readable[] readableArray = new Readable[bookArray.length + eBookArray.length];
		int i;
		int j = 0;
		for (i=0;i<(bookArray.length+eBookArray.length);i++){
			if (i<bookArray.length){
				readableArray[i] = bookArray[i];
			}else{
				readableArray[i] = eBookArray[j];
				j++;
			}
		}
				
		return readableArray; //readableArray;		
	}
	public Audio[] getAudioProducts() throws IOException{ // Fetches all audio products from the files and places in them in the readables array

		String[] MP3Info = readLines("MP3.txt");
		MP3[] MP3Array = new MP3[MP3Info.length];
		for (int j = 0; j< MP3Info.length; j++){
			String item = MP3Info[j];
			String[] tempArray = item.split(", ");
			MP3Array[j] = new MP3(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), false);
		}
		String[] CDInfo = readLines("CDs.txt"); //separates lines into strings in an array
		CD[] CDArray = new CD[CDInfo.length];
		for (int i = 0; i < CDInfo.length; i++){ 
			String item = CDInfo[i]; 
			String[] tempArray = item.split(", ");
			CDArray[i] = new CD(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), true);
			}
		Audio[] audioArray = new Audio[CDArray.length + MP3Array.length];
		int i;
		int j = 0;
		for (i=0;i<(CDArray.length+MP3Array.length);i++){
			if (i<CDArray.length){
				audioArray[i] = CDArray[i];
			}else{
				audioArray[i] = MP3Array[j];
				j++;
			}
		}
				
		return audioArray; //readableArray;	
	}

	public void showReadables() throws IOException{ //Displays all readable for browsing
		System.out.println(String.format("%-4s%-24s%-16s%-8s%-12s%-5s","sNo","Name","Author", "Price", "Quantity", "Type"));
		Readable[] readableArray = getReadables();
		int length = readableArray.length;
		String type = "";
		for (int i = 0; i<length; i++){
			Readable item = readableArray[i];
			if (item instanceof Book){
				type = "Book";
			}else if (item instanceof eBook){
				type = "eBook";
			}
			System.out.println(String.format("%-4d%-24s%-16s%-8d%-12d%-5s", item.sNo, item.name, item.authorName, item.price, item.quantity, type));
		}
	}
	public void showAudioProducts() throws IOException{ // Displays all audio products for browsing
		System.out.println(String.format("%-4s%-24s%-16s%-8s%-12s%-5s","sNo","Name","Artist", "Price", "Quantity", "Type"));
		Audio[] audioArray = getAudioProducts();
		int length = audioArray.length;
		String type = "";
		for (int i = 0; i<length; i++){
			Audio item = audioArray[i];
			if (item instanceof CD){
				type = "CD";
			}else if (item instanceof MP3){
				type = "MP3";
			}
			System.out.println(String.format("%-4d%-24s%-16s%-8d%-12d%-5s", item.sNo, item.name, item.artistName, item.price, item.quantity, type));
		}
	}
	public boolean search(String s, String f) {
		File file = new File(f);
		try {
			final Scanner fileScanner = new Scanner(file);
			while (fileScanner.hasNextLine()) {
				final String lineFromFile = fileScanner.nextLine();
				// Check for blank
				if (s == "" || s == "\n") {
					fileScanner.close();
					return false;
				}
				if (lineFromFile.contains(s)) {
					fileScanner.close();
					return true;
				} else {
					continue;
				}
			}
			fileScanner.close();
		}

		catch (FileNotFoundException e) {

		}
		return false;
	}
	public static String[] readLines(String filename) throws IOException, FileNotFoundException{
		//System.out.println("readlines");
		//System.out.println("1");
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try{
			//System.out.println(filename);
			//System.out.println(new File(filename).getAbsolutePath());
			fileReader = new FileReader(filename);
			//System.out.println(filename);
			//System.out.println("2");
			bufferedReader = new BufferedReader(fileReader);
			//System.out.println("3");
			List<String> lines = new ArrayList<String>();
			//System.out.println("4");
			String line = null;
			//System.out.println("5");
			while ((line = bufferedReader.readLine()) != null){
				lines.add(line);
				//System.out.println("6");
				}
			bufferedReader.close();
			String[] linesArray = new String[lines.size()];
			linesArray = lines.toArray(linesArray);
			return linesArray;
		}catch(FileNotFoundException e){
			System.out.println("FileNotFound");
		}
		return null;
		}
	
	public static void initCart(String u) throws IOException{
		String[] info = UserInterface.readLines("Cart_" + u + ".txt");
		ShoppingCart[] cartArray = new ShoppingCart[info.length];		
		for (int i = 0; i < info.length; i++){ 
			String item = info[i]; 
			String[] tempArray = item.split(",");
			cartArray[i] = new ShoppingCart(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), 1, false);
			boolean c = true;
			while (c){
				for (int j = 0; j < CDArray.length; j++)
					if (cartArray[i].getSerialNo() == CDArray[j].getSNo()){
						ShoppingCart.setPrice(CDArray[j].getPrice());
						ShoppingCart.setTax(CDArray[j].getTax());
						c = false;
					}
				for (int j = 0; j < MP3Array.length; j++)
					if (cartArray[i].getSerialNo() == MP3Array[j].getSNo()){
						ShoppingCart.setPrice(MP3Array[j].getPrice());
						ShoppingCart.setTax(MP3Array[j].getTax());
						c = false;
					}
				for (int j = 0; j < bookArray.length; j++)
					if (cartArray[i].getSerialNo() == bookArray[j].getSNo()){
						ShoppingCart.setPrice(bookArray[j].getPrice());
						ShoppingCart.setTax(bookArray[j].getTax());
						c = false;
					}
				for (int j = 0; j < eBookArray.length; j++)
					if (cartArray[i].getSerialNo() == eBookArray[j].getSNo()){
						ShoppingCart.setPrice(eBookArray[j].getPrice());
						ShoppingCart.setTax(eBookArray[j].getTax());
						c = false;
					}
				}
		}
		ShoppingCart.setContents(cartArray);
	}
	
	public static void displayCheckout(ShoppingCart[] s){
		for (int i = 0; i < s.length; i++){
			System.out.printf("%1s %25d %12d\n\n",s[i].getTitle(), s[i].getQuantity(), s[i].getPrice());
		}
		
		System.out.printf("%1s %10s %22s\n", "Environment Tax", "2%","6");
		System.out.printf("%5s %20s %22s\n\n","HST","13%","39");
		System.out.printf("%10s %15s %22s\n","Shipping","10%","30");
		System.out.printf("%53s\n", "__________");
		System.out.printf("%5s %44s\n\n", "Total","375$");
	}
}
		
		
