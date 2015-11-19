public class​MP3 extends ​Audio{
@Override
public int​getPrice(...){ // override and only call the
parent’s getPrice() to get the base price.
…
}
public class MP3 extends Audio{
	@Override
	public int getPrice(){
		int m = 18;
		return m;
	}
}