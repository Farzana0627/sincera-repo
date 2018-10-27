package Memento;

public class Calculator {

	private int x;
	private int y;
	CareTaker careTaker ;
	
	public Calculator(CareTaker careTaker) {
		this.careTaker =careTaker;
		
	}
	
	public void saveValues(int x, int y){
		this.x =x;
		this.y =y;			
		backupState();
	}
	
	public void backupState()
	{

		CaretakerInterface memento = new Memento(x,y);		
		careTaker.saveState(memento, this);
		getAnswer();
	}
	
	public void getAnswer()
	{
		int answer = (x+y);
		System.out.println("Answer: "+answer);
	}
	
	public void RestoreState(CaretakerInterface memento)
	{
		this.x= ((CalculatorInterface)memento).restoreX();
		this.y= ((CalculatorInterface)memento).restoreY();
		getAnswer();
		
	}
	
	public void undo(){
		careTaker.undoState();
	}

}
