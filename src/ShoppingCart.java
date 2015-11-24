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
	
	private String serialNo;
	private String Title;
	private String Date;
	private String Quantity;
	private String 
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
	
	public String getSerialNo(){
		return serialNo;
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
	
	public String updateDate(){
		Date = date();
		return Date;
	}
	
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
		if (s = false){
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
}

	


