
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HWK4_crawleg {
	
	public static ShoppingCart[] Contents;
	
	public static void main(String[] args) throws IOException {
		int n = 0;
		Scanner inputScanner = new Scanner(System.in);
		String scannerResult = "";
		UserInterface s = new UserInterface();
		User u = new User();
		s.changeCurrentPage(1);
		while (n != 3417) {
			try {
				//Login Page
				if (s.getCurrentPage() == 1) {
					System.out.println("1. Sign in");
					System.out.println("2. Sign up");
					System.out.print("Choose your option: ");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					n = Integer.parseInt(scannerResult);
					// If Sign In
					if (n == 1) {
						s.changeCurrentPage(3);
						continue;
					}
					// If Sign Up
					if (n == 2) {
						s.changeCurrentPage(2);
						continue;
					}

				}
				//Choose Username
				if(s.getCurrentPage()==2){
					System.out.println("Choose your username:");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					String data = scannerResult;
					// If exists
					if (search(data, "Users.txt") == true) {
						System.out.println("This name already exists, please choose another" + "\n");
						continue;
					}
					// User name doesn't exist
					else {
						u.getUsername(data);
						User.createUsername(data);
						initCart(u.returnUsername());
						ShoppingCart.setContents(Contents);
						s.changeCurrentPage(1);
					}
				}
				if(s.getCurrentPage()==3){
					System.out.print("Enter your username: ");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					String data = scannerResult;
					// Scanning the Users.txt file...
					if (search(data, "Users.txt") == false) {
						s.changeCurrentPage(4);
						continue;
					} else {
						System.out.println("Welcome " + data + "\n");
						u.getUsername(data);
						initCart(u.returnUsername());
						ShoppingCart.setContents(Contents);
						s.changeCurrentPage(5);
						continue;
					}
				}
				if(s.getCurrentPage()==4){
					System.out.println("No Access" + "\n");
					s.changeCurrentPage(1);
					continue;
				}
				if(s.getCurrentPage()==5){
					System.out.println("1. View Items By Category");
					System.out.println("2. View Shopping Cart");
					System.out.println("3. Sign Out");
					System.out.print("Choose your option: ");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					n = Integer.parseInt(scannerResult);
					// If Sign In
					if (n == 1) {
						s.changeCurrentPage(6);
						continue;
					}
					// If Sign Up
					if (n == 2) {
						s.changeCurrentPage(7);
						continue;
					}
					if (n == 3) {
						s.changeCurrentPage(1);
						continue;
					}
					
				}
				if(s.getCurrentPage()==6){
					System.out.println("1. Readables");
					System.out.println("2. Audio");
					System.out.println("");
					System.out.println("Choose your option: ");
					System.out.println("");
					System.out.println("Press -1 to return to");
					System.out.println("the previous menu");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					n = Integer.parseInt(scannerResult);
					// If Sign In
					if (n == 1) {
						s.changeCurrentPage(8);
						continue;
					}
					// If Sign Up
					if (n == 2) {
						s.changeCurrentPage(9);
						continue;
					}
					if (n == -1) {
						s.changeCurrentPage(5);
						continue;
					}
				}
				if(s.getCurrentPage()==7){
					System.out.println("Shopping Cart");
					System.out.println("");
					
					ShoppingCart.displayContents(u.returnUsername());
					System.out.println("");
					System.out.println("Press -1 to return to");
					System.out.println("the previous menu");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					n = Integer.parseInt(scannerResult);
					if (n == -1) {
						s.changeCurrentPage(5);
						continue;
					}
				}
				if(s.getCurrentPage()==8){
					s.changeCurrentPage(1);
					continue;
				}
				if(s.getCurrentPage()==9){
					s.changeCurrentPage(1);
					continue;
				}
				if(s.getCurrentPage()==10){
					s.changeCurrentPage(1);
					continue;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("\n" + "Please only enter integers" + "\n");
				continue;
			} catch (java.lang.NumberFormatException e) {
				System.out.println("\n" + "Please only enter integers" + "\n");
				continue;
			}
		}
		inputScanner.close();

	}

	// Function to search file for string
	public static boolean search(String s, String f) {
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
	//Initialize all books
	public static Book[] initBook(String text) throws IOException{
		//get books from Books.txt
		String[] info = UserInterface.readLines(text); //seperates lines into strings in an array
		Book[] bookArray = new Book[info.length];		
		for (int i = 0; i < info.length; i++){ 
			String item = info[i]; 
			String[] tempArray = item.split(",");
			bookArray[i] = new Book(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]));
				}
		return bookArray;
		}
	
	public static void initCart(String u) throws IOException{
		String[] info = UserInterface.readLines("cart_" + u + ".txt");
		ShoppingCart[] cartArray = new ShoppingCart[info.length];		
		for (int i = 0; i < info.length; i++){ 
			String item = info[i]; 
			String[] tempArray = item.split(",");
			cartArray[i] = new ShoppingCart(tempArray[0], tempArray[1], tempArray[2], tempArray[3]);
		}
		Contents = cartArray;
		}

}
