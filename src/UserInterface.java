
public class UserInterface {
	private array readables;
	private array audioProducts;
	private int currentPage; // the page number (P1..P10)
	public int getCurrentPage(){ //This method is for page navigation. Based on the values of the state variable, call different pages
	}
	public int changeCurrentPage(){// This method is for page navigation. It should change to current page and show the content.
	}
	public void getReadables(); // Fetches all readable from the files and places them in the readable array
	public void getAudioProducts(); // Fetches all audio products from the files and places in them in the readables array
	public void showReadables(); //Displays all readable for browsing
	public void showAudioProducts(); // Displays all audio products for browsing

}
}