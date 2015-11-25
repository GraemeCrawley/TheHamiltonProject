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
import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class UserInterface {
	@SuppressWarnings("unused")
	private Array[] readables;
	@SuppressWarnings("unused")
	private static Array[] audioProducts;
	private int currentPage; // the page number (P1..P10)
	public int getCurrentPage(){ //This method is for page navigation. Based on the values of the state variable, call different pages
		return currentPage;
	}
	public void changeCurrentPage(int n){// This method is for page navigation. It should change to current page and show the content.
		currentPage = n;
	}
	private String[] bookInfo;
	private static Book[] bookArray;
	private String[] eBookInfo;
	private static eBook[] eBookArray;
	public void getReadables() throws IOException {// Fetches all readable from the files and places them in the readable array
		//get books from Books.txt		
		bookInfo = readLines("Books.txt"); //seperates lines into strings in an array
		bookArray = new Book[bookInfo.length];
		for (int i = 0; i < bookInfo.length; i++){ 
			String item = bookInfo[i]; 
			String[] tempArray = item.split(", ");
			bookArray[i] = new Book(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), true);
		}
		//get eBooks from eBook.txt
		eBookInfo = readLines("Ebooks.txt");
		eBookArray = new eBook[eBookInfo.length];
		for (int j = 0; j< eBookInfo.length; j++){
			String item = eBookInfo[j];
			String[] tempArray = item.split(", ");
			eBookArray[j] = new eBook(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), false);
		}
		
	}
	private String[] CDInfo;
	private static CD[] CDArray;
	private String[] MP3Info;
	private static MP3[] MP3Array;
	public void getAudioProducts() throws IOException{ // Fetches all audio products from the files and places in them in the readables array
		//get CDs from CDs.txt
		String[] CDInfo = readLines("CDs.txt"); //seperates lines into strings in an array
		CD[] CDArray = new CD[CDInfo.length];		
		for (int i = 0; i < CDInfo.length; i++){ 
			String item = CDInfo[i]; 
			String[] tempArray = item.split(", ");
			CDArray[i] = new CD(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), true);
		}
		//get MP3s from MP3.txt
		String[] MP3Info = readLines("MP3.txt");
		MP3[] MP3Array = new MP3[MP3Info.length];
		for (int j = 0; j< MP3Info.length; j++){
			String item = MP3Info[j];
			String[] tempArray = item.split(", ");
			MP3Array[j] = new MP3(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), false);
		}
		System.out.println("THing worked");
	}
	public void showReadables(){ //Displays all readable for browsing
		System.out.println(String.format("%-4s%-16s%-16s%-5s%-8s%-6s","sNo","Name","Author", "Price", "Quantity", "Type"));
		for (int i = 0; i<bookArray.length; i++){
			Book book = bookArray[i];
			String type = "book";
			System.out.println(String.format("%4d%16s%16s%5d%4d%6s", book.sNo, book.name, book.authorName, book.price, type));
		}
		for (int i = 0; i<eBookArray.length; i++){
			eBook book = eBookArray[i];
			String type = "eBook";
			System.out.println(String.format("%4d%16s%16s%5d%4d%6s", book.sNo, book.name, book.authorName, book.price, type));
		}
	}
	public void showAudioProducts(){ // Displays all audio products for browsing
		System.out.println(String.format("%4d%16s%16s%5d%4d%6s","sNo","Name","Artist", "Price", "Type"));
		for (int i = 0; i<CDArray.length; i++){
			CD cd = CDArray[i];
			String type = "CD";
			System.out.println(String.format("%4d%16s%16s%5d%4d%6s", cd.sNo, cd.name, cd.artistName, cd.price, type));
		}
		for (int i = 0; i<eBookArray.length; i++){
			eBook book = eBookArray[i];
			String type = "eBook";
			System.out.println(String.format("%4d%16s%16s%5d%4d%6s", book.sNo, book.name, book.authorName, book.price, type));
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
	
	public static void initCart(String u) throws IOException{
		String[] info = UserInterface.readLines("Cart_" + u + ".txt");
		ShoppingCart[] cartArray = new ShoppingCart[info.length];		
		for (int i = 0; i < info.length; i++){ 
			String item = info[i]; 
			String[] tempArray = item.split(",");
			cartArray[i] = new ShoppingCart(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], tempArray[3], 1, false);
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
		
		
