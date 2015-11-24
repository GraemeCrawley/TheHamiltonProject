import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

public class ShoppingCart extends User{
	//private content 
	
	private String serialNo;
	private String Title;
	private String Date;
	private String Quantity;
	private static ShoppingCart[] Contents;
	
	
	
	public ShoppingCart(String s, String t, String d, String q){
		serialNo = s;
		Title = t;
		Date = d;
		Quantity = q;
	}
	/*
	public String getContent(ShoppingCart[] s){
		String 
		for(int i = 0; i < s.length; i++){
		}
	}
	*/	
	
	public static void setContents(ShoppingCart[] s){
		Contents = s;
	}
	
	public static void displayContents(String s) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Cart_" + s + ".txt"));
		String line;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
}
	
	/*
	public addItem(Item m, int n){
		ShoppingCart[] tempCart = new ShoppingCart[Contents.length + 1];
		for(int i = 0; i < Contents.length; i++){
			
		}
	}
}
	*/


