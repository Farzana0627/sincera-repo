package chap22.sec14.Deitel;

import java.util.Stack;

public class EvaluatePostfixExpression {
	
	
	public double Evaluate(StringBuffer postfix)
	{
		double StackTop1, StackTop2, value;
		Stack<Double> stack = new Stack<>();
		
		for ( int i = 0; i< postfix.length(); i++ )
		if ( !Character.isWhitespace( postfix.charAt(i)) && Character.isDigit( postfix.charAt(i)))
		{
		
			StringBuffer number= new StringBuffer();
			while(Character.isDigit( postfix.charAt(i)))
			{
				number.append(postfix.charAt(i));
				i++;
			}
			value = Integer.parseInt(number.toString());
			stack.push( value );
			System.out.println(stack);
			
		}
		else if ( !Character.isWhitespace( postfix.charAt(i))) 
		{
			StackTop2 = stack.pop();
			StackTop1 = stack.pop();
	
			value = Calculate(StackTop1, StackTop2, postfix.charAt(i));
			stack.push(value);
		
		}
		return stack.pop();
	}
		
		
	
	private double Calculate( double operand1, double operand2, char operator )
	{
		switch( operator ) {
			
			case '%':	
				return operand1 % operand2;
			case '*':
				return operand1 * operand2;
			case '/':
				return operand1 / operand2;
			case '^':	
				return Math.pow( operand1, operand2 );
			case '+':
				return operand1 + operand2;
			case '-':
				return operand1 - operand2;
		}
		return 0;
	}
		
		
}
