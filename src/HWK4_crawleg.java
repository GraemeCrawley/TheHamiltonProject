
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
	public static void main(String[] args) {
		int n = 0;
		Scanner inputScanner = new Scanner(System.in);
		String scannerResult = "";
		UserInterface r = new UserInterface();
		User u = new User();
		ShoppingCart s = new ShoppingCart();
		r.changeCurrentPage(1);
		while (n != 3417) {
			try {
				//Login Page
				if (r.getCurrentPage() == 1) {
					System.out.println("1. Sign in");
					System.out.println("2. Sign up");
					System.out.print("Choose your option: ");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					n = Integer.parseInt(scannerResult);
					// If Sign In
					if (n == 1) {
						r.changeCurrentPage(3);
						continue;
					}
					// If Sign Up
					if (n == 2) {
						r.changeCurrentPage(2);
						continue;
					}

				}
				//Choose Username
				if(r.getCurrentPage()==2){
					System.out.println("Choose your username:");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					String data = scannerResult;
					// If exists
					if (r.search(data, "Users.txt") == true) {
						System.out.println("This name already exists, please choose another" + "\n");
						continue;
					}
					// User name doesn't exist
					else {
						u.getUsername(data);
						User.createUsername(data);
						s.createCart(data, 0);
						r.changeCurrentPage(1);
					}
				}
				if(r.getCurrentPage()==3){
					System.out.print("Enter your username: ");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					String data = scannerResult;
					// Scanning the Userr.txt file...
					if (r.search(data, "Users.txt") == false) {
						r.changeCurrentPage(4);
						continue;
					} else {
						u.getUsername(data);
						s.createCart(data, 1);
						r.changeCurrentPage(5);
						continue;
					}
				}
				if(r.getCurrentPage()==4){
					System.out.println("No Access" + "\n");
					r.changeCurrentPage(1);
					continue;
				}
				if(r.getCurrentPage()==5){
					System.out.println("1. View Items By Category");
					System.out.println("2. View Shopping Cart");
					System.out.println("3. Sign Out");
					System.out.print("Choose your option: ");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					n = Integer.parseInt(scannerResult);
					// If Sign In
					if (n == 1) {
						r.changeCurrentPage(6);
						continue;
					}
					// If Sign Up
					if (n == 2) {
						r.changeCurrentPage(7);
						continue;
					}
					if (n == 3) {
						r.changeCurrentPage(1);
						continue;
					}
					
				}
				if(r.getCurrentPage()==6){
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
						r.changeCurrentPage(8);
						continue;
					}
					// If Sign Up
					if (n == 2) {
						r.changeCurrentPage(9);
						continue;
					}
					if (n == -1) {
						r.changeCurrentPage(5);
						continue;
					}
				}
				if(r.getCurrentPage()==7){
					System.out.println("Shopping Cart");
					System.out.println("");
					try {
					    BufferedReader lineReader = new BufferedReader(new FileReader("cart_" + u.returnUsername() + ".txt"));
					    String lineText = null;
					 
					    while ((lineText = lineReader.readLine()) != null) {
					        System.out.println(lineText);
					    }
					 
					    lineReader.close();
					} catch (IOException ex) {
					    System.err.println(ex);
					}
					System.out.println("");
					System.out.println("Press -1 to return to");
					System.out.println("the previous menu");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					n = Integer.parseInt(scannerResult);
					if (n == -1) {
						r.changeCurrentPage(5);
						continue;
					}
				}
				if(r.getCurrentPage()==8){
					r.changeCurrentPage(1);
					continue;
				}
				if(r.getCurrentPage()==9){
					r.changeCurrentPage(1);
					continue;
				}
				if(r.getCurrentPage()==10){
					r.changeCurrentPage(1);
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


	//Initialize all books
	public static Book[] initBook(String text) throws IOException{
		//get books from Bookr.txt
		String[] info = readLines(text); //seperates lines into strings in an array
		Book[] bookArray = new Book[info.length];		
		for (int i = 0; i < info.length; i++){ 
			String item = info[i]; 
			String[] tempArray = item.split(",");
			bookArray[i] = new Book(Integer.parseInt(tempArray[0]), tempArray[1], tempArray[2], Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]));
				}
		return bookArray;
		}
	


	public static String[] readLines(String filename) throws IOException {
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
