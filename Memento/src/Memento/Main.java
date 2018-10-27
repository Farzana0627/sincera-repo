package Memento;

public class Main {

	public static void main(String[] args) {
		
		CareTaker careTaker = new CareTaker();
		Calculator calculator = new Calculator(careTaker);	
					
		calculator.saveValues(4, 5);

		calculator.saveValues(14, 25);

		calculator.saveValues(41, 35);
	
		calculator.undo();

		calculator.undo();
		
		calculator.undo();
		

		

	

	}

}
