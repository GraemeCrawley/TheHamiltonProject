
/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */
import java.io.*;
import java.util.Scanner;

public class HWK4_crawleg {
	public static void main(String[] args) {
		int n = 0;
		Scanner inputScanner = new Scanner(System.in);
		String scannerResult = "";
		UserInterface s = new UserInterface();
		User user = new User();
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
						user.getUsername(data);
						User.createUsername(data);
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
						s.changeCurrentPage(5);
						continue;
					}
				}
				if(s.getCurrentPage()==4){
					System.out.println("No Access" + "\n");
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
}
