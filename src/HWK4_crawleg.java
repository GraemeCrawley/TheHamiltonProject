
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */
import java.io.*;
import java.util.Scanner;

public class HWK4_crawleg {
	public static void main(String[] args) throws IOException {
		int n = 0;
		Scanner inputScanner = new Scanner(System.in);
		String scannerResult = "";
		UserInterface r = new UserInterface();
		User u = new User();
		r.changeCurrentPage(1);
		int prevPage = 5;
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
					if (search(data, "Users.txt") == true) {
						System.out.println("This name already exists, please choose another" + "\n");
						continue;
					}
					// User name doesn't exist
					else {
						u.getUsername(data);
						User.createUsername(data);
						u.createCart(data, 0);
						UserInterface.initCart(data);
						//ShoppingCart.setContents(Contents);
						r.changeCurrentPage(1);
					}
				}
				if(r.getCurrentPage()==3){
					System.out.print("Enter your username: ");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					String data = scannerResult;
					// Scanning the Userr.txt file...
					if (search(data, "Users.txt") == false) {
						r.changeCurrentPage(4);
						continue;
					} else {
						u.getUsername(data);
						u.createCart(data, 1);
						UserInterface.initCart(data);
						//ShoppingCart.setContents(Contents);
						System.out.println("Welcome " + data + "\n");
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
						prevPage = 5;
						continue;
					}
					// If Sign Up
					if (n == 2) {
						r.changeCurrentPage(7);
						prevPage = 5;
						continue;
					}
					if (n == 3) {
						r.changeCurrentPage(1);
						prevPage = 5;
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
					if (n == 1) {
						r.changeCurrentPage(8);
						prevPage = 6;
						continue;
					}
					if (n == 2) {
						r.changeCurrentPage(9);
						prevPage = 6;
						continue;
					}
					if (n == -1) {
						r.changeCurrentPage(prevPage);
						continue;
					}
				}
				if(r.getCurrentPage()==7){
					System.out.println("Shopping Cart");
					System.out.println("");
					//ShoppingCart.displayContents(u.returnUsername());
					System.out.println("");
					System.out.println("Press -1 to return to");
					System.out.println("the previous menu");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					n = Integer.parseInt(scannerResult);
					if (n == -1) {
						r.changeCurrentPage(prevPage);
						continue;
					}
				}
				//Readables
				if(r.getCurrentPage()==8){
					System.out.println("Readables");
					System.out.println("");
					r.showReadables();
					System.out.println("Choose option");
					System.out.println("Press -1 to return to");
					System.out.println("the previous menu");
					scannerResult = inputScanner.nextLine();
					System.out.println("n=scanner");
					n = Integer.parseInt(scannerResult);
					if(n==-1){
						r.changeCurrentPage(prevPage);
					}
					//Assume they've chosen an item
					else{
						//check to make sure the number they've entered is valid for the selected type i.e. audio/readable
						//ask for a quantity
						int quantity = 0;
						String title = "harry potter"; //replace with real title
						String titleType = "Book"; //replace with real type
						System.out.print("Enter quantity: ");
						scannerResult = inputScanner.nextLine();
						quantity = Integer.parseInt(scannerResult);  //change to be specific for the selected item
//						selectedItem = "random book"; //change to be specific for the selected item
						if(quantity == 1){
							System.out.println(quantity+" "+title+" "+titleType+" added to your cart.");
						}
						else{
							System.out.println(quantity+" "+title+" "+titleType+"s added to your cart.");
						}
						System.out.println("Press -2 to Continue Shopping or Press 0 to CheckOut");
						scannerResult = inputScanner.nextLine();
						n = Integer.parseInt(scannerResult);
						if(n==0){
							r.changeCurrentPage(10);
						}
						else if(n==-2){
							r.changeCurrentPage(6);
						}
						
					}
					continue;
				}
				//Audio
				if(r.getCurrentPage()==9){
					System.out.println("Audio");
					//System.out.println("TEST");
					System.out.println("");
					//System.out.println("showReadables - HWK4");
					r.showAudioProducts();
					System.out.println("Choose option");
					System.out.println("Press -1 to return to");
					System.out.println("the previous menu");
					scannerResult = inputScanner.nextLine();
					System.out.println("n=scanner");
					n = Integer.parseInt(scannerResult);
					if(n==-1){
						r.changeCurrentPage(prevPage);
					}
					//Assume they've chosen an item
					else{
						//check to make sure the number they've entered is valid for the selected type i.e. audio/readable
						//ask for a quantity
						int quantity = 0;
						String title = "harry potter"; //replace with real title
						String titleType = "MP3"; //replace with real type
						System.out.print("Enter quantity: ");
						scannerResult = inputScanner.nextLine();
						quantity = Integer.parseInt(scannerResult);  //change to be specific for the selected item
						if(quantity == 1){
							System.out.println(quantity+" "+title+" "+titleType+" added to your cart.");
						}
						else{
							System.out.println(quantity+" "+title+" "+titleType+"s added to your cart.");
						}
						System.out.println("Press -2 to Continue Shopping or Press 0 to CheckOut");
						scannerResult = inputScanner.nextLine();
						n = Integer.parseInt(scannerResult);
						if(n==0){
							r.changeCurrentPage(10);
						}
						else if(n==-2){
							r.changeCurrentPage(6);
						}
						
					}
					continue;
				}
				//CheckOut
				if(r.getCurrentPage()==10){
					System.out.println("Billing Information:");
					System.out.printf("%6s %30s %8s\n\n","Name","Quantity","Price" );
					//UserInterface.displayCheckout(Contents);
					System.out.print("Are you sure you want to pay? yes or no. ");
					scannerResult = inputScanner.nextLine();
					System.out.println("");
					String s = scannerResult;
					if (s.equalsIgnoreCase("yes")){
						//Print confirmation number, ect
						r.changeCurrentPage(1);
						continue;
					}
					if (s.equalsIgnoreCase("no")){
						r.changeCurrentPage(5);
						continue;
					}
					else{
						System.out.println("Please only enter yes or no" + "\n");
					}
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
}
