package chap22.sec13.Deitel;

import java.util.Scanner;

public class PostfixEvaluator {
	public static void main( String args[] )
	{
		Scanner scr= new Scanner(System.in);
		StringBuffer postfix = new StringBuffer();
		System.out.println("Postfix expression:");
		postfix.append(scr.nextLine());
		scr.close();
		EvaluatePostfixExpression object= new EvaluatePostfixExpression();
		double result = object.Evaluate(postfix);
		System.out.println( "Result: "+result );
	
	}
}
