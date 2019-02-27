package chap22.sec10.Deitel;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Class22_10 {
	public static void main(String[] args) {
		Scanner scr= new Scanner(System.in);
		System.out.println("Write a sentence: ");
		String s= scr.nextLine();
		scr.close();
		String[] words = s.replaceAll("[^a-zA-Z ]", "").split("\\s+");
		Stack<String> stack= new Stack<>();
		stack.addAll(Arrays.asList(words));
		while(!stack.isEmpty()){
		
			System.out.println(stack.peek());
			stack.pop();
			
		}
	}
}
