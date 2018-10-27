package Stack;

import java.util.Stack;

public class mainStack {
	
	public static void main(String[] args) {
		

		// TODO Auto-generated constructor stub
		Stack<Number> stackTest = new Stack<>();
		stackTest.push(12L);// long value
		stackTest.push(3);// int value
		stackTest.add(1.2); // float value
		stackTest.push(132.63322);// double value
		double i;
		//i=(Double) stackTest.pop();
		stackTest.peek();// same as stackTest.top()
		System.out.println(stackTest.peek());
		stackTest.add(56);
		System.out.println(stackTest);
	}
}
