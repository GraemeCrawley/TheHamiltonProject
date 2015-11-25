import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * Name: Gregory Smilski, Graeme Crawley, Alexandria Crump
 * MacID: smilsksi, crawleg, crumpal
 * Student Number: 1404091,  1417993, 1310858
 * Description:
 */

public class ShoppingCart extends User{
	//private content 
	
	private int sNo; //initializes serial number of item in cart
	private String Title; //initializes Titles of item in cart
	private String Date; // initializes Date of item in cart
	private int Quantity; //initializes Quantity of item in cart
	private static int Price; // initializes price of item in cart
	private static boolean Tax; //initializes tax boolean (which determines if there will be environment tax/shipping on the item

	private static ShoppingCart[] Contents; //initializes array of shopping cart objetcs
	
	public ShoppingCart(int s, String t, String d, int q, int p, boolean x){
		sNo = s;
		Title = t;
		Date = d;
		Quantity = q;
		Price = p;
		Tax = x;
	}
	
	public static void setPrice(int p){
		Price = p;
	}
	public static void setTax(boolean t){
		Tax = t;
	}
	public static void setContents(ShoppingCart[] s){
		Contents = s;
	}	
	public int getSerialNo(){
		return sNo;
	}
	public String getTitle(){
		return Title;
	}
	public String getDate(){
		return Date;
	}
	public int getQuantity(){
		return Quantity;
	}
	public int getPrice(){
		return Price;
	}
	public boolean getTax(){
		return Tax;
	}
	public ShoppingCart[] getContents(){
		return Contents;
	}
	
	public String updateDate(){
		Date = date();
		return Date;
	}
	
	public int updateQuantity(int s){
		int c = s + Quantity;
		Quantity = c;
		return Quantity;
	}
	
	public static void displayContents(String s) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Cart_" + s + ".txt"));
		String line;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}

	
	public static void addItem(Item m, int n, String name) throws IOException{
		boolean s = true;
		int prevLength = Contents.length;
		int d = 0;
		while (s){
			for(int i = 0; i < Contents.length; i++){
				if (Contents[i].getSerialNo() == (Item.sNo)){
					d = i;
					s = false;
				}
			}
		}
		//Did find it in the file
		if (s == false){
			Contents[d].updateQuantity(n);
			Contents[d].updateDate();
			PrintWriter out = new PrintWriter("Cart_" + name + ".txt");
			for (int i = 0; i < Contents.length; i++ ){
				out.println(Contents[i].sNo + ", " + Contents[prevLength].Title + ", " + Contents[prevLength].Date + ", " + Contents[prevLength].Quantity);
			}
			out.close();
			
		}
		//Didn't find it in the file
		else{
			ShoppingCart[] tempCart = new ShoppingCart[prevLength + 1];
			for(int i = 0; i < Contents.length; i++){
				tempCart[i] = Contents[i];
			}
			Contents = tempCart;
			Contents[prevLength] = new ShoppingCart(Item.sNo,Item.Title,date(),Item.quantity, Item.price, Item.tax);
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Cart_" + name + ".txt", true)));
			out.println(Contents[prevLength].sNo + ", " + Contents[prevLength].Title + ", " + Contents[prevLength].Date + ", " + Contents[prevLength].Quantity);
			out.close();
		}
	}
	
	
	
	public static String date(){
		DateFormat format = new SimpleDateFormat("dd/MM/yyy");
		Calendar d = Calendar.getInstance();
		return format.format(d.getTime());
	}
	
}
