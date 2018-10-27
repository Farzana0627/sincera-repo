package Memento;

public class Memento implements CalculatorInterface,CaretakerInterface {

	private int x;
	private int y;
	
	public Memento(int x, int y) {
		this.x =x;
		this.y =y;	
		
	}

	@Override
	public int restoreX() {
		
		return x;
	}

	@Override
	public int restoreY() {
		
		return y;
	}
		
	

}
