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
		while(n != 3417){
			try{
			UserInterface s = new UserInterface();
			s.changeCurrentPage(1);
			//Login Screen
			System.out.println("1. Sign in");
			System.out.println("2. Sign up");
			System.out.print("Choose your option: ");
			n = Integer.parseInt(scanner());
			//If Sign In
			if (n==1){
				System.out.print("Enter your username: ");
				String data = scanner();
				//Scanning the Users.txt file...
				if (search(data, "Users.txt") == false){
					System.out.println("No Access"+"\n");
					continue;
				}
				else{
					System.out.println("Welcome "+data+"\n");
					
				}
				
			}
			//If Sign Up
			if (n==2){
				System.out.println("Choose your username:");
				String data = scanner();
				//If exists
				if(search(data, "Users.txt")==true){
					System.out.println("This name already exists, please choose another"+ "\n");
					continue; //TELL THEM IT ALREADY EXISTS AND HAVE THEM REENTER TO RETRY
				}
				//User name doesn't exist
				else{
					try{
						//Write to file
						BufferedWriter bw = new BufferedWriter(new FileWriter("Users.txt", true));
						bw.write(data);
						bw.newLine();
					    bw.flush();
						System.out.println("Username successfully added"+"\n");
						continue;
					}
					catch (FileNotFoundException e){
						System.out.println("FileNotFoundException");
						continue;
					}
					catch (IOException e){
						System.out.println("IOException");
						continue;
					}
				}
			}
			}
			catch (java.util.InputMismatchException e){
				System.out.println("\n"+"Please only enter integers"+"\n");
				
				continue;
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
				   //Check for blank 
				   if(s=="" || s=="\n"){
					   scanner.close();
					   return false;
				   }
				   if(lineFromFile.contains(s)) {
					   scanner.close();
				       return true;
				   }
				   scanner.close();
				}
		}
		
		catch (FileNotFoundException e){
			
		}
		
		return false;
	}
	public static String scanner(){
		Scanner scanner = new Scanner(System.in);
		String scannerResult = scanner.nextLine();
		System.out.println("");
		scanner.close();
		return scannerResult;
	}
}



