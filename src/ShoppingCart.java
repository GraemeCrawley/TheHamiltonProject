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
	private ShoppingCart[] Contents;
	
	
	
	public ShoppingCart(String s, String t, String d, String q){
		serialNo = s;
		Title = t;
		Date = d;
		Quantity = q;
	}
	
	public void initCart(String u) throws IOException{
		String[] info = HWK4_crawleg.readLines("cart_" + u + ".txt");
		ShoppingCart[] cartArray = new ShoppingCart[info.length];		
		for (int i = 0; i < info.length; i++){ 
			String item = info[i]; 
			String[] tempArray = item.split(",");
			cartArray[i] = new ShoppingCart(tempArray[0], tempArray[1], tempArray[2], tempArray[3]);
				}
		Contents = cartArray;
		
	}
	
	public String getContent(ShoppingCart[] s){
		String l = null;
		for(int i = 0; i < s.length; i++){
			l =  serialNo + ", " + Title + ", " + Date + ", " + Quantity + '\n';
		}
		return l;
	}
	
	public ShoppingCart[] setContents()
}
	


