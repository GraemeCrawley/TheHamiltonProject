import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	private String Quantity;
	private static int Price;
	private static boolean Tax;

	private static ShoppingCart[] Contents;
	
	public ShoppingCart(int s, String t, String d, String q, int p, boolean x){
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
	public String getQuantity(){
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
	
//	public String updateDate(){
//		Date = date();
//		return Date;
//	}
	
	public String updateQuantity(String s){
		int c = Integer.parseInt(s) + Integer.parseInt(Quantity);
		Quantity = Integer.toString(c);
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

	/*
	
	public void addItem(Item m, int n){
		boolean s = true;
		int prevLength = Contents.length;
		int d;
		while (s)
		for(int i = 0; i < Contents.length; i++){
			if ((Contents[i].getSerialNo()).equals(Item.getSerialNo())){
				d = i;
				s = false;
			}
		}
		if (s == false){
			Contents[d].updateQuantity(Item.getQuantity());
			Contents[d].updateDate();
		}
		else{
			ShoppingCart[] tempCart = new ShoppingCart[prevLength + 1];
			for(int i = 0; i < Contents.length; i++){
				tempCart[i] = Contents[i];
			}
			Contents = tempCart;
			Contents[prevLength] = ShoppingCart(Item.serialNumber,Item.Title,date(),Item.Quantity)
			}
	}
	
	public String date(){
		DateFormat format = new SimpleDateFormat("dd/MM/yyy");
		Calendar d = Calendar.getInstance();
		return format.format(d.getTime());
	}
	*/
}
