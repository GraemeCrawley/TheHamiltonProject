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
			
			//If Sign In
			if (n==1){
				boolean t = false;
				System.out.print("Enter your username:");
				Scanner input2 = new Scanner(System.in);
				String data2 = input2.nextLine();
				//Scanning the Users.txt file...
				t = search(data2, "Users.txt");
				if (t == false){
					System.out.println("Access Denied");
					continue;
				}
				else{
					System.out.println("Welcome "+data2);
				}
				
			}
			//If Sign Up
			if (n==2){
				System.out.println("Choose your username:");
				Scanner input3 = new Scanner(System.in);
				String data3 = input3.nextLine();
				//If exists
				if(search(data3, "Users.txt")==true){
					System.out.println("This name already exists, please choose another");
					continue; //TELL THEM IT ALREADY EXISTS AND HAVE THEM REENTER TO RETRY
				}
				//Uname doesn't exist
				else{
					try{
						//Write to file
						BufferedWriter bw = new BufferedWriter(new FileWriter("Users.txt", true));
						
						System.out.println("Username successfully added");
						continue;
					}
					catch (FileNotFoundException e){
						continue;
					}
				}
			}
		}
			
	}
	//Function to search file for string
	public static boolean search(String s, String f) {
		File file = new File(f);
		try{
			final Scanner scanner = new Scanner(file);	
			while (scanner.hasNextLine()) {
				   final String lineFromFile = scanner.nextLine();
				   if(lineFromFile.contains(s)) { 
				       return true;
				   }
				   else{
					   return false;
				   }
				}
		}
		catch (FileNotFoundException e){
			continue;
		}
		return false;
	}
}



