/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */
import java.io.*;
import java.util.Scanner;


public class HWK4_crawleg{
	public static void main(String[] args){
		int n = 0;
		String k = "";
		while(n != 3417){
			//Login Screen
			System.out.println("1. Sign in");
			System.out.println("2. Sign up");
			Scanner reader = new Scanner(System.in);  // Reading from System.in
			System.out.print("Choose your option: ");
			n = reader.nextInt(); // Scans the next token of the input as an int.
			//If Sign Up
			if (n==1){
				System.out.println("Choose your username:");
				Scanner input = new Scanner(System.in);
				String data = input.nextLine();
				continue;	
			}
			//If Sign In
			if (n==2){
				boolean t = false;
				System.out.print("Enter your username:");
				Scanner input2 = new Scanner(System.in);
				String data2 = input2.nextLine();
				//Scanning the Users.txt file...
				File file = new File("Users.txt");
				try{
					final Scanner scanner = new Scanner(file);	
					while (scanner.hasNextLine()) {
						   final String lineFromFile = scanner.nextLine();
						   if(lineFromFile.contains(data2)) { 
						       t = true;
						       break;
						   }
						}
				}
				catch (FileNotFoundException e){
					
				}
				
				if (t == false){
					System.out.println("Access Denied");
					continue;
				}
				
			}
		}
			
	}
}



