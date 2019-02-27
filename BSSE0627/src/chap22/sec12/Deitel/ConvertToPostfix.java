package chap22.sec12.Deitel;

import java.util.Stack;

public class ConvertToPostfix {

	public StringBuffer Convert(StringBuffer infix)
	{
		StringBuffer postfix = new StringBuffer();
		Stack <Character> stack = new Stack<Character>();
		
		stack.push( '(' );
		infix.append(')');
		int i=0;
		while(!stack.isEmpty())
		{
			
			if (Character.isDigit( infix.charAt(i))){
				while(Character.isDigit( infix.charAt(i)))
				{
					postfix.append( infix.charAt(i)) ;
					i++;
				}
				postfix.append(" ");
			}
			
			if (infix.charAt(i) == '(')
				stack.push( '(' );
			
			else if (Operator(infix.charAt(i))) {
			
				while ( Operator( stack.peek() ) && HigherPrecedence(stack.peek(),infix.charAt(i)))
					postfix.append(stack.pop()+" " );
				stack.push( infix.charAt( i ) );
			} 
			else if (infix.charAt(i) == ')') 
			{
				while (stack.peek()!= '(')
					postfix.append(stack.pop()+" ");
				stack.pop();
			} 
			i++;
		} 
		return postfix;
	}
	private static boolean Operator( char op )
	
	{	
		if ( op == '+' || op == '-' || op == '*' || op == '/' || op == '^' || op== '%')
	
			return true;
	
		else return false;
	
	}
	private static boolean HigherPrecedence( char op1, char op2)
	
	{
	
		if ( op2 == '^' )
			return false;
			
	
		else if ( op1 =='^' )
	
			return true;
	
		else if ( op1 =='*' || op1 == '/' || op1=='%')
	
			return true;
	
		else if ( op1 =='+' || op1 =='-' )
	
			if ( op2 == '*' || op2 == '/' || op2=='%' )
				return false;
			else
				return true;
		return false;
	
	
	}
}
