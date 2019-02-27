package chap22.sec12.Deitel;

import java.util.Scanner;

public class InfixToPostfixConverter {
	public static void main(String[] args) {

	System.out.println("Enter infix expression: ");
	Scanner scr= new Scanner(System.in);
	
	StringBuffer infix= new StringBuffer();
	infix.append(scr.nextLine());
	scr.close();
	ConvertToPostfix object= new ConvertToPostfix();
	StringBuffer postfix = object.Convert(infix);
	System.out.println( "The postfix is: " +postfix );
	
	}
}
