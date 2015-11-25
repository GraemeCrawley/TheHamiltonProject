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
	
	private int sNo;
	private String Title;
	private String Date;
	private int Quantity;
	private static int Price;
	private static boolean Tax;

	private static ShoppingCart[] Contents;
	
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

	
	public void addItem(Item m, int n) throws IOException{
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
		if (s == false){
			Contents[d].updateQuantity(Item.quantity);
			Contents[d].updateDate();
		}
		else{
			ShoppingCart[] tempCart = new ShoppingCart[prevLength + 1];
			for(int i = 0; i < Contents.length; i++){
				tempCart[i] = Contents[i];
			}
			Contents = tempCart;
			Contents[prevLength] = new ShoppingCart(Item.sNo,Item.Title,date(),Item.quantity, Item.price, Item.tax);
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("horse.txt", true)));
			out.println(Contents[prevLength].sNo + ", " + Contents[prevLength].Title + ", " + Contents[prevLength].Date + ", " + Contents[prevLength].Quantity);
			out.close();
		}
	}
	
	public String date(){
		DateFormat format = new SimpleDateFormat("dd/MM/yyy");
		Calendar d = Calendar.getInstance();
		return format.format(d.getTime());
	}
	
}
