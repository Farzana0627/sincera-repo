
public class UnsynchronizedBuffer implements Buffer{
	private int value=-1;

	@Override
	public void write(int a) {
		// TODO Auto-generated method stub
		value=a;
		
	}
	@Override
	public int read() {
		// TODO Auto-generated method stub
		return value;
	}

	
	
}
