	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;


	/*
	 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
	 * MacID: smilsksi, crawleg, crumpal
	 * Student Number: 1404091,  1417993, 1310858
	 * Description:
	 */

	public class User {

		private String username;
		
		public void getUsername(String s){ // stores the username
			this.username = s;
		}
		
		public String returnUsername(){
			return this.username;
		}
		public static void createUsername(String s)
		{
			try{
				//Write to file
				BufferedWriter bw = new BufferedWriter(new FileWriter("Users.txt", true));
				bw.write(s);
				bw.newLine();
			    bw.flush();
			    bw.close();
				System.out.println("Username successfully added"+"\n");
			}
			catch (FileNotFoundException e){
				System.out.println("FileNotFoundException");
			}
			catch (IOException e){
				System.out.println("IOException");
			}
			try {
				File file = new File("cart_" + s + ".txt");
				
				if (!file.createNewFile()){
					System.out.println("FileAlreadyExiss");
				}
				
				}catch (IOException e) {
				      e.printStackTrace();
			}
		}
	}



