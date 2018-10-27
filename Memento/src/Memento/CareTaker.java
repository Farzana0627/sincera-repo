package Memento;

import java.util.Stack;

public class CareTaker{
  
   Stack<CaretakerInterface> stack = new Stack<CaretakerInterface>();
   CaretakerInterface memento = null;
   Calculator calculator;
   
   
   public CareTaker() {
	   memento = (CaretakerInterface)new Memento(0,0);
	   stack.push(memento);
	
   }
   
   public void saveState(CaretakerInterface c, Calculator calculator)
   {
	   this.calculator = calculator;
	  
	   stack.push(c);
   }
   
   public void undoState()
   {
	   if(stack.size()==1) {
		   System.out.println("No previous state is saved.");
		   calculator.getAnswer();
		   return;
	   }
	   
	   System.out.println("Undo Result : ");
	   
	   if(stack.size()>1)
		   memento = stack.pop();
	  
	   calculator.RestoreState(stack.peek());

   }

}
