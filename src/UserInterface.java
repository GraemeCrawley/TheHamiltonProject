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
	private Array readables;
	@SuppressWarnings("unused")
	private Array audioProducts;
	private int currentPage;// the page number (P1..P10)
	public int getCurrentPage(){ //This method is for page navigation. Based on the values of the state variable, call different pages
		return currentPage;
	}
	public void changeCurrentPage(int n){// This method is for page navigation. It should change to current page and show the content.
		currentPage = n;
	}
	public Readable[] getReadables() throws IOException {// Fetches all readable from the files and places them in the readable array
		
		//get eBooks from eBook.txt
		String[] eBookInfo = readLines("Ebooks.txt");
		eBook[] eBookArray = new eBook[eBookInfo.length];
		for (int j = 0; j< 2/*eBookInfo.length*/; j++){
			String item = eBookInfo[j];
			String[] tempArray = item.split(",");
			System.out.println("j: "+j);
			System.out.println("ebookinfo: "+ eBookInfo.length);
			eBookArray[j] = new eBook(3, "name", "author", 100, 10); //Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4])
		
		}
		//get books from Books.txt		
		String[] bookInfo = readLines("Books.txt"); //separates lines into strings in an array
		Book[] bookArray = new Book[bookInfo.length];
			for (int i = 0; i < bookInfo.length; i++){ 
				//String item = bookInfo[i]; 
				//String[] tempArray = item.split(",");
				//bookArray[i] = new Book(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]));
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
				
		return null; //readableArray;		
	}
	public void getAudioProducts() throws IOException{ // Fetches all audio products from the files and places in them in the readables array
		//get CDs from CDs.txt
		String[] CDInfo = readLines("CD.txt"); //seperates lines into strings in an array
		CD[] CDArray = new CD[CDInfo.length];		
		for (int i = 0; i < CDInfo.length; i++){ 
			String item = CDInfo[i]; 
			String[] tempArray = item.split(",");
			CDArray[i] = new CD(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]));
		}
		//get MP3s from MP3.txt
		String[] MP3Info = readLines("MP3.txt");
		MP3[] MP3Array = new MP3[MP3Info.length];
		for (int j = 0; j< MP3Info.length; j++){
			String item = MP3Info[j];
			String[] tempArray = item.split(",");
			MP3Array[j] = new MP3(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]));
		}	
	}
	public void showReadables() throws IOException{ //Displays all readable for browsing
		System.out.println(String.format("%-4s%-16s%-16s%-5s%-8s%-6s","sNo","Name","Author", "Price", "Quantity", "Type"));
		Readable[] readableArray = getReadables();
		int length = readableArray.length;
		/*for (int i = 0; i<length; i++){
			Readable item = readableArray[i];
			
			System.out.println(String.format("%4d%16s%16s%5d%4d%6s", item.sNo, item.name, item.authorName, item.price, item.type));
		}*/
	}
	/*public void showAudioProducts(){ // Displays all audio products for browsing
		System.out.println(String.format("%4d%16s%16s%5d%4d%6s","sNo","Name","Artist", "Price", "Type"));
		for (int i = 0; i<this.CDArray.length; i++){
			CD cd = CDArray[i];
			String type = "CD";
			System.out.println(String.format("%4d%16s%16s%5d%4d%6s", cd.sNo, cd.name, cd.artistName, cd.price, type));
		}
		for (int i = 0; i<this.eBookArray.length; i++){
			eBook book = eBookArray[i];
			String type = "eBook";
			System.out.println(String.format("%4d%16s%16s%5d%4d%6s", book.sNo, book.name, book.authorName, book.price, type));
		}
	}*/
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
		System.out.println("1");
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try{
			System.out.println(filename);
			System.out.println(new File(filename).getAbsolutePath());
			fileReader = new FileReader(filename);
			System.out.println(filename);
			System.out.println("2");
			bufferedReader = new BufferedReader(fileReader);
			System.out.println("3");
			List<String> lines = new ArrayList<String>();
			System.out.println("4");
			String line = null;
			System.out.println("5");
			while ((line = bufferedReader.readLine()) != null){
				lines.add(line);
				System.out.println("6");
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
			cartArray[i] = new ShoppingCart(tempArray[0], tempArray[1], tempArray[2], tempArray[3]);
		}
		ShoppingCart.setContents(cartArray);
		}
}